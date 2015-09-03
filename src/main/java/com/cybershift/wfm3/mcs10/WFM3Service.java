package com.cybershift.wfm3.mcs10;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-08-31T09:23:43.650-07:00
 * Generated source version: 3.1.2
 * 
 */
@WebServiceClient(name = "WFM3Service", 
                  wsdlLocation = "file:/Users/collinbrown/Development/V2/Convergys/code/Pulse/java/Pulse.Server.Percero.Agent.Listener/src/main/resources/estart.wsdl",
                  targetNamespace = "http://www.cybershift.com/wfm3/mcs10/") 
public class WFM3Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.cybershift.com/wfm3/mcs10/", "WFM3Service");
    public final static QName WFM3ServiceSoapPort = new QName("http://www.cybershift.com/wfm3/mcs10/", "WFM3ServiceSoapPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/Users/collinbrown/Development/V2/Convergys/code/Pulse/java/Pulse.Server.Percero.Agent.Listener/src/main/resources/estart.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WFM3Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/Users/collinbrown/Development/V2/Convergys/code/Pulse/java/Pulse.Server.Percero.Agent.Listener/src/main/resources/estart.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WFM3Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WFM3Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WFM3Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public WFM3Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public WFM3Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public WFM3Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns WFM3ServicePortType
     */
    @WebEndpoint(name = "WFM3ServiceSoapPort")
    public WFM3ServicePortType getWFM3ServiceSoapPort() {
        return super.getPort(WFM3ServiceSoapPort, WFM3ServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WFM3ServicePortType
     */
    @WebEndpoint(name = "WFM3ServiceSoapPort")
    public WFM3ServicePortType getWFM3ServiceSoapPort(WebServiceFeature... features) {
        return super.getPort(WFM3ServiceSoapPort, WFM3ServicePortType.class, features);
    }

}