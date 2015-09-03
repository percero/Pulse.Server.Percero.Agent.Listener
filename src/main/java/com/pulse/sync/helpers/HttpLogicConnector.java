package com.pulse.sync.helpers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.Binding;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.SentinelCommands;

import com.cybershift.wfm3._5._3.WFM3String;
import com.cybershift.wfm3._5._3.WFM3ValueObject;
import com.cybershift.wfm3.mcs10.ObjectFactory;
import com.cybershift.wfm3.mcs10.RetrieveData;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

@Component
public class HttpLogicConnector {

	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired @Value("$pf{connector.soap.templateDirectory}")
	String soapTemplateDirectory = "";

	public HttpLogicConnector() {
		// TODO Auto-generated constructor stub
	}
	
	private final static Map<String, MethodResponsePattern> methodResponsePatterns = new HashMap<String, HttpLogicConnector.MethodResponsePattern>();

	@PostConstruct
	public void runTests() {
		
//		String estartWsdlUrl = "http://localhost:7001/webservice/estart.wsdl";
//		SoapConnectorDefinition soapConnector = importSoapConnectorDefinition(estartWsdlUrl, true);
//		System.out.println(soapConnector.toString());
//		ObjectFactory mcs10Factory = new ObjectFactory();
//		com.cybershift.wfm3._5._3.ObjectFactory objectFactory = new com.cybershift.wfm3._5._3.ObjectFactory();
//		RetrieveData retrieveData = mcs10Factory.createRetrieveData();
//		retrieveData.setBusinessObjectName("ACCRUALS_EMPLOYEES");
//		WFM3ValueObject queryValueObject = objectFactory.createWFM3ValueObject();
//		queryValueObject.setPageNumber(new BigInteger("1"));
//		queryValueObject.setPageSize(new BigInteger("2"));
//		
//		WFM3String wfm3String = objectFactory.createWFM3String();
//		wfm3String.setName("ACCRUALS_EMPLOYEES_PAYROLL");
//		wfm3String.setString("10851886002");
//		queryValueObject.getStringAttributeOrDoubleAttributeOrIntegerAttribute().add(wfm3String);
//		
//		retrieveData.setQueryValueObject(queryValueObject);
//		runDynamicWsdl(estartWsdlUrl, "retrieveData", retrieveData);
		
//		String protocol = "http";
//		String host = "orlawv513.na.convergys.com";
//		int port = 7001;
//		String file = "/webservice/services/WFM3Service";
		
		// Create the root hash
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("clientName", "CONVERGYS");
		root.put("userName", "mobileapp");
		root.put("password", "mobile");
		root.put("value", "10851886002");
		
		try {
			runFreemarkerTest("EmployeeAccruals", root);
		} catch(Exception e) {
			e.printStackTrace();
		}

		
		
//		String wsdlUrl = "http://api.bioinfo.no/wsdl/EchoService.wsdl";
//		String methodName = "SayHi";
//		runDynamicWsdl(wsdlUrl, methodName, "Test message");
//		try {
//			run_employeeAccrual();
//		} catch (ConnectorException e) {
//			e.printStackTrace();
//		}
		
	}
	
	Configuration cfg = null;
	
	public void runFreemarkerTest(String operationName, Map<String, Object> root) throws IOException, TemplateException, ConnectorException, URISyntaxException {
//		String template = "";
//    	try {
//    		InputStream is = HttpLogicConnector.class.getResourceAsStream(
//    				"/soap/EmployeeAccruals/request.xml.ftl");
//    		StringWriter writer = new StringWriter();
//    		IOUtils.copy(is, writer);
//    		template = writer.toString();
//    	} catch (IOException e) {
//    		e.printStackTrace();
//    	}

		if (cfg == null) {
	    	cfg = new Configuration(Configuration.VERSION_2_3_23);
//	    	URL soapFolder = HttpLogicConnector.class.getResource("/soap/EmployeeAccruals");
	    	cfg.setDirectoryForTemplateLoading(new File(soapTemplateDirectory));
	    	cfg.setDefaultEncoding("UTF-8");
	    	cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		}
		
		Properties properties = new Properties();
		File propertiesFile = new File(soapTemplateDirectory + "/" + operationName + "/connector.properties");
		FileInputStream is = new FileInputStream(propertiesFile);
		properties.load(is);
		is.close();
		
		String protocol = properties.getProperty("protocol");
		String host = properties.getProperty("host");
		int port = Integer.valueOf(properties.getProperty("port"));
		String file = properties.getProperty("file");
		
		Template template = cfg.getTemplate(operationName + "/request.xml.ftl");
    	
		StringWriter stringWriter = new StringWriter();
		template.process(root, stringWriter);
		
		stringWriter.close();
		stringWriter.flush();
		
		String request = stringWriter.toString();
		System.out.println(request);
		
		String result = sendPost(protocol, host, port, file, request);
		System.out.println(result);
	}
	
	JaxWsDynamicClientFactory dcf = null;
	Map<String, SoapConnectorDefinition> soapConnectors = new HashMap<String, SoapConnectorDefinition>();
	
	public SoapConnectorDefinition importSoapConnectorDefinition(String wsdlUrl) {
		return importSoapConnectorDefinition(wsdlUrl, false);
	}

	/**
	 * Imports a WSDL from a live web service for the purpose of exposing the operations within this ActiveStack application.
	 * @param wsdlUrl
	 * @param forceImport - Set to TRUE to force a "refresh" of the WSDL
	 * @return
	 */
	public SoapConnectorDefinition importSoapConnectorDefinition(String wsdlUrl, Boolean forceImport) {
		SoapConnectorDefinition soapConnector = null;
		
		if (!forceImport) {
			soapConnector = soapConnectors.get(wsdlUrl);
		}
		
		if (soapConnector != null) {
			return soapConnector;
		}
		
		if (classLoader == null) {
			classLoader = Thread.currentThread().getContextClassLoader();
		}
		if (dcf == null) {
			dcf = JaxWsDynamicClientFactory.newInstance();
		}
		Client client = dcf.createClient(wsdlUrl, classLoader);

		soapConnector = new SoapConnectorDefinition();
		soapConnector.wsdlUri = wsdlUrl;
		soapConnector.client = client;

		Endpoint endpoint = client.getEndpoint();

		Binding binding = endpoint.getBinding();
		BindingInfo bindingInfo = binding.getBindingInfo();
		Collection<BindingOperationInfo> operations = bindingInfo
	            .getOperations();
		
		soapConnector.setName(bindingInfo.getName().getLocalPart());
		soapConnector.setNamespaceURI(bindingInfo.getName().getNamespaceURI());
		soapConnector.setPrefix(bindingInfo.getName().getPrefix());
		soapConnector.setOperations(new HashMap<String, HttpLogicConnector.ActiveStackSoapOperationDefinition>());
		
		Set<String> packageNames = new HashSet<String>();
		Set<Package> packages = new HashSet<Package>();
		Set<Class> clazzes = new HashSet<Class>();
		
		for (BindingOperationInfo boi : operations) {
			OperationInfo oi = boi.getOperationInfo();
			BindingMessageInfo inputMessageInfo = boi.getInput();
			List<MessagePartInfo> parts = inputMessageInfo
					.getMessageParts();
			System.out.println("function name: "
					+ oi.getName().getLocalPart());

			ActiveStackSoapOperationDefinition operationDefinition = new ActiveStackSoapOperationDefinition();
			soapConnector.getOperations().put(oi.getName().getLocalPart(), operationDefinition);
			operationDefinition.setName(oi.getName().getLocalPart());
			operationDefinition.setNamespaceURI(oi.getName().getNamespaceURI());
			operationDefinition.setPrefix(oi.getName().getPrefix());
			operationDefinition.setDescription(inputMessageInfo.getDocumentation());
			operationDefinition.setPartsMap(new HashMap<String, HttpLogicConnector.ActiveStackSoapPartDefinition>());
			
			for(MessagePartInfo nextPart : parts) {
				System.out.println(nextPart.getIndex() + ": " + nextPart.getConcreteName().getLocalPart() + " (" + nextPart.getTypeClass().getCanonicalName() + ")");
				ActiveStackSoapPartDefinition partDefinition = new ActiveStackSoapPartDefinition();
				partDefinition.setConcreteName(nextPart.getConcreteName());
				partDefinition.setElementName(nextPart.getElementQName());
				partDefinition.setElement(nextPart.isElement());
				partDefinition.setIndex(nextPart.getIndex());
				partDefinition.setTypeClass(nextPart.getTypeClass());
				partDefinition.setTypeName(nextPart.getTypeQName());
				operationDefinition.getPartsMap().put(nextPart.getConcreteName().getLocalPart(), partDefinition);
				
				Object typeClassObject;
				try {
					clazzes.add(nextPart.getTypeClass());
					typeClassObject = nextPart.getTypeClass().newInstance();
					
					Package thePackage = typeClassObject.getClass().getPackage();
					packages.add(thePackage);
					packageNames.add(thePackage.getName());
					
					System.out.println(typeClassObject);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
//		for(Package nextPackage : packages) {
//			ArrayList<Class<?>> packageClasses = getClassesForPackage(nextPackage);
//			System.out.println(packageClasses.toString());
//		}
		
		Object[] myClazzes = clazzes.toArray();
		
		soapConnectors.put(soapConnector.getNamespaceURI(), soapConnector);

		return soapConnector;
	}

	private static ArrayList<Class<?>> getClassesForPackage(Package pkg) {
	    String pkgname = pkg.getName();
	    ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
	    // Get a File object for the package
	    File directory = null;
	    String fullPath;
	    String relPath = pkgname.replace('.', '/');
	    System.out.println("ClassDiscovery: Package: " + pkgname + " becomes Path:" + relPath);
	    URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
	    System.out.println("ClassDiscovery: Resource = " + resource);
	    if (resource == null) {
	        throw new RuntimeException("No resource for " + relPath);
	    }
	    fullPath = resource.getFile();
	    System.out.println("ClassDiscovery: FullPath = " + resource);

	    try {
	        directory = new File(resource.toURI());
	    } catch (URISyntaxException e) {
	        throw new RuntimeException(pkgname + " (" + resource + ") does not appear to be a valid URL / URI.  Strange, since we got it from the system...", e);
	    } catch (IllegalArgumentException e) {
	        directory = null;
	    }
	    System.out.println("ClassDiscovery: Directory = " + directory);

	    if (directory != null && directory.exists()) {
	        // Get the list of the files contained in the package
	        String[] files = directory.list();
	        for (int i = 0; i < files.length; i++) {
	            // we are only interested in .class files
	            if (files[i].endsWith(".class")) {
	                // removes the .class extension
	                String className = pkgname + '.' + files[i].substring(0, files[i].length() - 6);
	                System.out.println("ClassDiscovery: className = " + className);
	                try {
	                    classes.add(Class.forName(className));
	                } 
	                catch (ClassNotFoundException e) {
	                    throw new RuntimeException("ClassNotFoundException loading " + className);
	                }
	            }
	        }
	    }
	    else {
	        try {
	            String jarPath = fullPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");
	            JarFile jarFile = new JarFile(jarPath);         
	            Enumeration<JarEntry> entries = jarFile.entries();
	            while(entries.hasMoreElements()) {
	                JarEntry entry = entries.nextElement();
	                String entryName = entry.getName();
	                if(entryName.startsWith(relPath) && entryName.length() > (relPath.length() + "/".length())) {
	                    System.out.println("ClassDiscovery: JarEntry: " + entryName);
	                    String className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
	                    System.out.println("ClassDiscovery: className = " + className);
	                    try {
	                        classes.add(Class.forName(className));
	                    } 
	                    catch (ClassNotFoundException e) {
	                        throw new RuntimeException("ClassNotFoundException loading " + className);
	                    }
	                }
	            }
	        } catch (IOException e) {
	            throw new RuntimeException(pkgname + " (" + directory + ") does not appear to be a valid package", e);
	        }
	    }
	    return classes;
	}	
//	Client client = null;
	ClassLoader classLoader = null;
	public void runDynamicWsdl(String wsdlUrl, String methodName, Object arg) {
		SoapConnectorDefinition soapConnector = importSoapConnectorDefinition(wsdlUrl);
		 
		Object[] res;
		try {
			
			// Validate that this method exists.
			ActiveStackSoapOperationDefinition existingDefinition = soapConnector.getOperations().get(methodName);
			if (existingDefinition == null) {
				throw new ConnectorException(ConnectorException.INVALID_METHOD, ConnectorException.INVALID_METHOD_CODE);
			}
			
//			res = soapConnector.client.invoke("SayHi", "test echo");
			res = soapConnector.client.invoke(methodName, arg);
			System.out.println(methodName + " response: " + res[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object run_employeeAccrual() throws ConnectorException {
		Object result = null;
		
		MethodResponsePattern methodResponsePattern = methodResponsePatterns.get("EmployeeAccrual");
		if (methodResponsePattern == null) {
			methodResponsePattern = new MethodResponsePattern();
			methodResponsePattern.methodId = "EmployeeAccrual";
//			methodResponsePattern.successResponsePattern = Pattern.compile("/(?s)ValueObjects=&quot;(.*?)&quot;/");// Pattern.DOTALL);
			methodResponsePattern.successResponsePattern = Pattern.compile("/(?s)ValueObjects(.*?)ValueObjects>/", Pattern.DOTALL);
			methodResponsePattern.failureResponsePattern = Pattern.compile("^.");
			methodResponsePattern.errorResponsePattern = Pattern.compile("^.");
			methodResponsePattern.resultResponsePattern = Pattern.compile(".*");
			
			methodResponsePatterns.put("EmployeeAccrual", methodResponsePattern);
		}
		
		String protocol = "http";
		String host = "localhost";
		int port = 8900;
		String file = "/estart/employee_accruals";
		String requestBody = "   <soapenv:Header>" +
"      <mcs:UsernameToken>" +
"         <mcs:clientName>CONVERGYS</mcs:clientName>" +
"         <mcs:user>csadmin</mcs:user>" +
"         <mcs:password>pass123</mcs:password>" +
"      </mcs:UsernameToken>" +
"   </soapenv:Header>" +
"   <soapenv:Body>" +
"      <mcs:RetrieveData>" +
"         <mcs:businessObjectName>ACCRUALS_EMPLOYEES</mcs:businessObjectName>" +
"         <mcs:queryValueObject  pageNumber=\"1\" pageSize=\"2\" >" +
"            <!--You have a CHOICE of the next 11 items at this level-->" +
"            <ns:StringAttribute name=\"ACCRUALS_EMPLOYEES_PAYROLL\">" +
"               <ns:string>10851886002</ns:string>" +
"            </ns:StringAttribute>" +
"            </mcs:queryValueObject>" +
"      </mcs:RetrieveData>" +
"   </soapenv:Body>";
		
		String httpResult = sendPost(protocol, host, port, file, requestBody);
		String soapResult = null;
		try {
			soapResult = runSoap(protocol, host, port, file, requestBody);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(httpResult != null ? httpResult.toString() : "NULL response");
		
		// Now gauge the response
		try {
			Matcher successMatcher = methodResponsePattern.successResponsePattern.matcher(httpResult);
			boolean found = successMatcher.find();
			boolean matches = successMatcher.matches();
			if (found || matches) {
				// Success!
				if (found) {
					int numResults = successMatcher.groupCount();
					System.out.println(successMatcher.group(1));
					String[] arrayResults = new String[numResults];
					
					for(int i=0; i<numResults; i++) {
						arrayResults[i] = successMatcher.group(i);
					}
					
					result = arrayResults;
				}
				else {
					result = true;
				}
				return result;
			}
			else if (methodResponsePattern.failureResponsePattern.matcher(httpResult).matches()) {
				// Failure!
				result = methodResponsePattern.resultResponsePattern.split(httpResult);
			}
			else if (methodResponsePattern.errorResponsePattern.matcher(httpResult).matches()) {
				// Error!
				result = methodResponsePattern.resultResponsePattern.split(httpResult);
			}
			else {
				// Unexpected result
				throw new ConnectorException(ConnectorException.RESPONSE_PROCESS_FAILED, ConnectorException.RESPONSE_PROCESS_FAILED_CODE);
			}
		} catch(Exception e) {
			throw new ConnectorException(ConnectorException.RESPONSE_PROCESS_FAILED, ConnectorException.RESPONSE_PROCESS_FAILED_CODE);
		}
		
		return result;
	}
	
	protected String runSoap(String protocol, String host, int port, String file, String requestBody) throws Exception {
		// Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = protocol + "://" + host;
        if (port != 80){
        	url += ":" + port;
        }
        url += file;
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(protocol, host, port, requestBody), url);

        // print SOAP Response
        System.out.print("Response SOAP Message:");
        soapResponse.writeTo(System.out);

        soapConnection.close();
        
        return soapResponse.getSOAPBody().getTextContent();
	}
	
	private static SOAPMessage createSOAPRequest(String protocol, String host, int port, String requestBody) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = protocol + "://" + host;
        if (port != 80){
        	serverURI += ":" + port;
        }

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("example", serverURI);

        /*
        Constructed SOAP Request Message:
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
            <SOAP-ENV:Header/>
            <SOAP-ENV:Body>
                <example:VerifyEmail>
                    <example:email>mutantninja@gmail.com</example:email>
                    <example:LicenseKey>123</example:LicenseKey>
                </example:VerifyEmail>
            </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
         */

        // SOAP Body
        envelope.setTextContent(requestBody);
//        SOAPBody soapBody = envelope.getBody();
//        SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
//        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
//        soapBodyElem1.addTextNode("mutantninja@gmail.com");
//        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
//        soapBodyElem2.addTextNode("123");
//
//        MimeHeaders headers = soapMessage.getMimeHeaders();
//        headers.addHeader("SOAPAction", serverURI  + "VerifyEmail");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }
	
	protected String sendGet(String protocol, String host, int port, String file) throws ConnectorException {
		String result = null;

		URL url;
		try {
			url = new URL(protocol, host, port, file);
		} catch (MalformedURLException e) {
			throw new ConnectorException(ConnectorException.INVALID_URI, ConnectorException.INVALID_URI_CODE, e.getMessage());
		}
		URLConnection connection;
		try {
			connection = url.openConnection();
			setConnectionRequestMethod(connection, "GET");

			result = handleHttpResponse(connection);
		} catch (IOException e) {
			throw new ConnectorException(ConnectorException.UNABLE_TO_REACH_HOST, ConnectorException.UNABLE_TO_REACH_HOST_CODE, e.getMessage());
		}
			
		return result;
	}

	protected String sendPost(String protocol, String host, int port, String file, String requestBody) throws ConnectorException {
		String result = null;

		URL url;
		try {
			url = new URL(protocol, host, port, file);
		} catch (MalformedURLException e) {
			throw new ConnectorException(ConnectorException.INVALID_URI, ConnectorException.INVALID_URI_CODE, e.getMessage());
		}
		URLConnection connection;
		try {
			connection = url.openConnection();
			
			setConnectionRequestMethod(connection, "POST");
			
			connection.setDoOutput(true);
			
			DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
			outputStream.writeBytes(requestBody);
			outputStream.flush();
			outputStream.close();
			
			result = handleHttpResponse(connection);
		} catch (IOException e) {
			throw new ConnectorException(ConnectorException.UNABLE_TO_REACH_HOST, ConnectorException.UNABLE_TO_REACH_HOST_CODE, e.getMessage());
		}
			
		return result;
	}
	
	private String handleHttpResponse(URLConnection connection) throws IOException {
		int responseCode = getConnectionResponseCode(connection);
		logger.debug("HTTP Response Code for " + connection.getURL().toString() + " -> " + responseCode);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String nextLine = null;
		StringBuffer response = new StringBuffer();
		
		while ((nextLine = in.readLine()) != null) {
			response.append(nextLine);
		}
		
		in.close();
		
		return response.toString();
	}
	
	private void setConnectionRequestMethod(URLConnection connection, String requestMethod) throws ProtocolException {
		if (connection instanceof HttpURLConnection) {
			((HttpURLConnection)connection).setRequestMethod( requestMethod );
		}
		else if (connection instanceof HttpsURLConnection) {
			((HttpsURLConnection)connection).setRequestMethod( requestMethod );
		}
	}
	
	private int getConnectionResponseCode(URLConnection connection) throws IOException {
		if (connection instanceof HttpURLConnection) {
			return ((HttpURLConnection)connection).getResponseCode();
		}
		else if (connection instanceof HttpsURLConnection) {
			return ((HttpsURLConnection)connection).getResponseCode();
		}
		else {
			return 0;
		}
	}
	
	private class MethodResponsePattern {
		String methodId = "";
		
		Pattern successResponsePattern;
		Pattern failureResponsePattern;
		Pattern errorResponsePattern;

		Pattern resultResponsePattern;
	}
	
	public class SoapConnectorDefinition {
		
		private String name;
		private String namespaceURI;
		private String wsdlUri;
		private String prefix;
		private Client client;
		
		private Map<String, ActiveStackSoapOperationDefinition> operations;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getWsdlUri() {
			return wsdlUri;
		}
		
		public void setWsdlUri(String wsdlUri) {
			this.wsdlUri = wsdlUri;
		}
		
		public String getNamespaceURI() {
			return namespaceURI;
		}

		public void setNamespaceURI(String namespaceURI) {
			this.namespaceURI = namespaceURI;
		}

		public String getPrefix() {
			return prefix;
		}
		
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		
		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public Map<String, ActiveStackSoapOperationDefinition> getOperations() {
			return operations;
		}

		public void setOperations(Map<String, ActiveStackSoapOperationDefinition> operations) {
			this.operations = operations;
		}
	}
	
	public class ActiveStackSoapOperationDefinition {
		
		private String name;
		private String description;
		private String namespaceURI;
		private String prefix;
		private Map<String, ActiveStackSoapPartDefinition> partsMap;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getNamespaceURI() {
			return namespaceURI;
		}
		public void setNamespaceURI(String namespaceURI) {
			this.namespaceURI = namespaceURI;
		}
		public String getPrefix() {
			return prefix;
		}
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		public Map<String, ActiveStackSoapPartDefinition> getPartsMap() {
			return partsMap;
		}
		public void setPartsMap(Map<String, ActiveStackSoapPartDefinition> partsMap) {
			this.partsMap = partsMap;
		}
	}
	
	public class ActiveStackSoapPartDefinition {
		
		private QName concreteName;
		private QName elementName;
		private Boolean element;
		private QName pname;
		private Class typeClass;
		private QName typeName;
		private int index;
		public QName getConcreteName() {
			return concreteName;
		}
		public void setConcreteName(QName concreteName) {
			this.concreteName = concreteName;
		}
		public QName getElementName() {
			return elementName;
		}
		public void setElementName(QName elementName) {
			this.elementName = elementName;
		}
		public Boolean getElement() {
			return element;
		}
		public void setElement(Boolean element) {
			this.element = element;
		}
		public QName getPname() {
			return pname;
		}
		public void setPname(QName pname) {
			this.pname = pname;
		}
		public Class getTypeClass() {
			return typeClass;
		}
		public void setTypeClass(Class typeClass) {
			this.typeClass = typeClass;
		}
		public QName getTypeName() {
			return typeName;
		}
		public void setTypeName(QName typeName) {
			this.typeName = typeName;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
	}
}
