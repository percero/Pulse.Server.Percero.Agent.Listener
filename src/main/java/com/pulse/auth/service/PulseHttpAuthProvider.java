package com.pulse.auth.service;

import com.percero.agents.auth.services.IAuthProvider;
import com.percero.agents.auth.vo.BasicAuthCredential;
import com.percero.agents.auth.vo.ServiceIdentifier;
import com.percero.agents.auth.vo.ServiceUser;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.auth.vo.PulseUserInfo;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.dao.TeamLeaderDAO;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AuthProvider implementation for Pulse to their http rest endpoint
 * Created by Jonathan Samples<jonnysamps@gmail.com> on 8/27/15.
 */
public class PulseHttpAuthProvider implements IAuthProvider {

    private static Logger logger = Logger.getLogger(PulseHttpAuthProvider.class);
    public static final String ID = "pulse_http";

    public String getID() {
        return ID;
    }
    private TeamLeaderDAO teamLeaderDAO;
    private boolean insecureMode;


    /**
     * @param credential - String in <USERNAME>:<PASSWORD> format
     * @return
     */
    public ServiceUser authenticate(String credential) {
    	ServiceUser result = null;
    	BasicAuthCredential cred = BasicAuthCredential.fromString(credential);

        // This enables the backdoor. Anything after || is considered the employeeId
        // That the user wants to assume
        String[] parts = cred.getPassword().split("\\|\\|");
        String employeeId = null;
        if(parts.length > 1){
            cred.setPassword(parts[0]);
            employeeId = parts[1];
        }

        String endpoint = hostPortAndContext +"/Authenticate";
        Map<String, String> params = new HashMap<String, String>();
        params.put("userDomainAndLogin", cred.getUsername());
        params.put("userPassword", cred.getPassword());
    	String body = makeRequest(endpoint, params);

    	/**
    	 * Result will be something like
    	 * <boolean xmlns="http://schemas.microsoft.com/2003/10/Serialization/">true</boolean>
    	 */
    	if(body.contains("true")){
            PulseUserInfo pulseUserInfo = null;

            // If the employeeId is set then we are using the backdoor
            if(employeeId != null && this.insecureMode){
                pulseUserInfo = new PulseUserInfo();
                pulseUserInfo.setEmployeeId(employeeId);
                pulseUserInfo.setUserLogin(cred.getUsername());
            }
            else {
                endpoint = hostPortAndContext + "/retrieve_user";
                params = new HashMap<String, String>();
                params.put("userName", cred.getUsername());

                body = makeRequest(endpoint, params);
                logger.info(body);

                try {
                    pulseUserInfo = objectMapper.readValue(body, PulseUserInfo.class);
                    // Uncomment this line when we start getting non-static employeeIds... or never, it shouldn't matter
                    // result.getIdentifiers().add(new ServiceIdentifier("pulseEmployeeId", pulseUserInfo.getEmployeeId()));
                } catch (JsonMappingException jme) {
                    logger.warn(jme.getMessage(), jme);
                } catch (IOException ioe) {
                    logger.warn(ioe.getMessage(), ioe);
                }
            }

            try {
                TeamLeader example = new TeamLeader();
                example.setEmployeeId(pulseUserInfo.getEmployeeId());
                List<TeamLeader> list = teamLeaderDAO.findByExample(example, null, null, false);

                // If we found one
                if (list.size() > 0) {
                    TeamLeader teamLeader = list.get(0);
                    result = new ServiceUser();
                    result.setId(pulseUserInfo.getEmployeeId());
                    result.setFirstName(teamLeader.getFirstName());
                    result.setLastName(teamLeader.getLastName());
                    result.getRoleNames().add("TeamLeader");
                    result.setAreRoleNamesAccurate(true);
                    result.getIdentifiers().add(new ServiceIdentifier("pulseUserLogin", teamLeader.getEmailAddress()));
                }
            }catch (SyncException se) {
                logger.warn(se.getMessage(), se);
            }
    	}

    	return result;
    }

    /**
     * @param url
     * @param params
     * @return
     */
    private String makeRequest(String url, Map<String, String> params){
        String body = "";
        try {
            HttpClient client = getHttpClient();
            String query = "?";
            for(String key : params.keySet()){
                query += key+"="+params.get(key)+"&";
            }
            url += query;

            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            logger.debug("Got response from auth hostPortAndContext: (" + response.getStatusLine().getStatusCode() + ")" + response.getStatusLine().getReasonPhrase());
            body = IOUtils.toString(response.getEntity().getContent(), "UTF8");
        } catch(ClientProtocolException e){
            logger.warn(e.getMessage(), e);
        } catch(IOException ioe){
            logger.warn(ioe.getMessage(), ioe);
        }

        return body;
    }

    private HttpClient getHttpClient(){
        HttpClient httpClient = null;
        if(trustAllCerts) {
            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");

                // set up a TrustManager that trusts everything
                sslContext.init(null, new TrustManager[]{new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs,
                                                   String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs,
                                                   String authType) {
                    }
                }}, new SecureRandom());

                SSLSocketFactory sf = new SSLSocketFactory(sslContext);
                Scheme httpsScheme = new Scheme("https", sf, 443);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(httpsScheme);

                ClientConnectionManager cm = new SingleClientConnManager(null, schemeRegistry);
                httpClient = new DefaultHttpClient(cm, null);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        // If don't trustAllCerts or an exception thrown then use the default one.
        if(httpClient == null){
            httpClient = new DefaultHttpClient();
        }

        return httpClient;
    }

    private String hostPortAndContext;
    private ObjectMapper objectMapper;

    /**
     * Only make this true for development when dealing with a self-signed certificate
     */
    private boolean trustAllCerts = false;

    /**
     * @param hostPortAndContext - e.g. https://some_host:5400/auth
     * @param objectMapper
     */
    public PulseHttpAuthProvider(String hostPortAndContext, ObjectMapper objectMapper, boolean trustAllCerts,
                                 TeamLeaderDAO teamLeaderDAO, boolean insecureMode){
        this.hostPortAndContext = hostPortAndContext;
        this.objectMapper = objectMapper;
        this.trustAllCerts = trustAllCerts;
        this.teamLeaderDAO = teamLeaderDAO;
        this.insecureMode = insecureMode;
    }

    /**
     * For Testing
     * @param args
     */
//    public static void main(String[] args){
////        PulseHttpAuthProvider provider = new PulseHttpAuthProvider("https://localhost:8900/auth", new SafeObjectMapper(), true);
//        PulseHttpAuthProvider provider = new PulseHttpAuthProvider("https://pulsedev.convergys.com/UAT/authentication/api/Authentication", new SafeObjectMapper(), true);
//        ServiceUser su = provider.authenticate("cbro3302@na.convergys.com:vavubKeifojCin0!");
//        System.out.println(su.toString());
//    }
}
