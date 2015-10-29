package com.pulse.auth.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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
import org.springframework.util.StringUtils;

import com.percero.agents.auth.services.IAuthProvider;
import com.percero.agents.auth.vo.AuthCode;
import com.percero.agents.auth.vo.AuthProviderResponse;
import com.percero.agents.auth.vo.BasicAuthCredential;
import com.percero.agents.auth.vo.ServiceIdentifier;
import com.percero.agents.auth.vo.ServiceUser;
import com.percero.agents.sync.exceptions.SyncException;
import com.pulse.auth.vo.PulseUserInfo;
import com.pulse.mo.TeamLeader;
import com.pulse.mo.dao.TeamLeaderDAO;

/**
 * AuthProvider implementation for Pulse to their http rest endpoint
 * Created by Jonathan Samples<jonnysamps@gmail.com> on 8/27/15.
 */
public class PulseHttpAuthProvider implements IAuthProvider {

    private static Logger logger = Logger.getLogger(PulseHttpAuthProvider.class);
    public static final String ID = "pulse_http";
    
    private static final long TIMEOUT_TIME = 2500;

    public String getID() {
        return ID;
    }
    private TeamLeaderDAO teamLeaderDAO;
    private boolean insecureMode;


    /**
     * @param credential - String in <USERNAME>:<PASSWORD> format
     * @return
     */
    public AuthProviderResponse authenticate(String credential) {
        AuthProviderResponse response = new AuthProviderResponse();
    	ServiceUser serviceUser = null;
    	BasicAuthCredential cred = BasicAuthCredential.fromString(credential);

        // This enables the backdoor. Anything after || is considered the employeeId
        // That the user wants to assume
        String[] parts = cred.getPassword().split("\\|\\|");
        String employeeId = null;
        if(parts.length > 1){
            cred.setPassword(parts[0]);
            employeeId = parts[1];
        }
        
        logger.debug("Autheticating user " + cred.getUsername());

        String endpoint = hostPortAndContext +"/Authenticate";
        Map<String, String> params = new HashMap<String, String>();
        params.put("userDomainAndLogin", URLEncoder.encode(cred.getUsername()));
        params.put("userPassword", URLEncoder.encode(cred.getPassword()));
    	String body = makeRequest(endpoint, params);

    	/**
    	 * Result will be something like
    	 * <boolean xmlns="http://schemas.microsoft.com/2003/10/Serialization/">true</boolean>
    	 */
    	if(body.contains("true")){
    		logger.debug("Authentication successful for user " + cred.getUsername() + (this.insecureMode ? " (dev mode)" : ""));
            PulseUserInfo pulseUserInfo = null;

            // If the employeeId is set then we are using the back door
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
                    if(pulseUserInfo.getEmployeeId() == null)
                        response.authCode = PulseAuthCode.RETRIEVE_USER_FAILED;

                } catch (JsonMappingException jme) {
                    logger.warn(jme.getMessage(), jme);
                    response.authCode = PulseAuthCode.RETRIEVE_USER_FAILED;
                } catch (IOException ioe) {
                    logger.warn(ioe.getMessage(), ioe);
                    response.authCode = PulseAuthCode.RETRIEVE_USER_FAILED;
                }
            }

            try {
            	if ( pulseUserInfo != null && StringUtils.hasText(pulseUserInfo.getEmployeeId()) ) {
            		long timeStart = System.currentTimeMillis();
	            	logger.debug("Retrieving TeamLeader object for user/employee " + cred.getUsername() + "/" + pulseUserInfo.getEmployeeId());
	                TeamLeader example = new TeamLeader();
	                example.setEmployeeId(pulseUserInfo.getEmployeeId());
	                List<TeamLeader> list = teamLeaderDAO.findByExample(example, null, null, false);
	
	                // If we found one
	                if (list.size() > 0) {
	                    TeamLeader teamLeader = list.get(0);
	                    serviceUser = new ServiceUser();
	                    serviceUser.setId(pulseUserInfo.getEmployeeId());
	                    serviceUser.setFirstName(teamLeader.getFirstName());
	                    serviceUser.setLastName(teamLeader.getLastName());
	                    serviceUser.getRoleNames().add("TeamLeader");
	                    serviceUser.setAreRoleNamesAccurate(true);
	                    serviceUser.getIdentifiers().add(new ServiceIdentifier("email", teamLeader.getEmailAddress()));
	                	logger.debug("TeamLeader " + teamLeader.getID() + " found for user " + cred.getUsername() + "/" + pulseUserInfo.getEmployeeId());
                        response.serviceUser = serviceUser;
                        response.authCode = AuthCode.SUCCESS;
	                }
	                else {
                        logger.warn("LOGIN FAILED: No TeamLeader object found for user " + cred.getUsername() + "/" + pulseUserInfo.getEmployeeId());
                        response.authCode = PulseAuthCode.NO_TEAM_LEADER;
                    }
	                
	        		logger.debug("Auth Retrieve PulseUser Time: " + (System.currentTimeMillis() - timeStart) + "ms [TeamLeader: " + pulseUserInfo.getEmployeeId() + "]");
            	} else if(response.authCode == null) // code hasn't been set
                    response.authCode = PulseAuthCode.EMPLOYEEID_NOT_FOUND;

            }catch (SyncException se) {
                logger.warn(se.getMessage(), se);
                response.authCode = new AuthCode(500, se.getMessage());
            }
    	}
        else
            response.authCode = PulseAuthCode.BAD_USER_PASS;


    	return response;
    }

    /**
     * @param url
     * @param params
     * @return
     */
    private String makeRequest(String url, Map<String, String> params){
    	long timeStart = System.currentTimeMillis();

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
            logger.debug("Auth Request Time: " + url + " - " + (System.currentTimeMillis()-timeStart) + "ms [" + this.getClass().getName() + "]");
        } catch(ClientProtocolException e){
            logger.warn(e.getMessage(), e);
        } catch(IOException ioe){
            logger.warn(ioe.getMessage(), ioe);
        }
        
        long timeEnd = System.currentTimeMillis();
        long totalTime = timeEnd - timeStart;
    	if (totalTime > TIMEOUT_TIME) {
    		logger.warn("Slow Auth: " + url + " - " + totalTime + "ms [" + this.getClass().getName() + "]");
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
