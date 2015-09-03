
package com.cybershift.wfm3.mcs10;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-08-31T09:23:43.577-07:00
 * Generated source version: 3.1.2
 * 
 */
public final class WFM3ServicePortType_WFM3ServiceSoapPort_Client {

    private static final QName SERVICE_NAME = new QName("http://www.cybershift.com/wfm3/mcs10/", "WFM3Service");

    private WFM3ServicePortType_WFM3ServiceSoapPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WFM3Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WFM3Service ss = new WFM3Service(wsdlURL, SERVICE_NAME);
        WFM3ServicePortType port = ss.getWFM3ServiceSoapPort();  
        
        {
        System.out.println("Invoking deleteData...");
        com.cybershift.wfm3.mcs10.DeleteData _deleteData_body = null;
        try {
            java.math.BigInteger _deleteData__return = port.deleteData(_deleteData_body);
            System.out.println("deleteData.result=" + _deleteData__return);

        } catch (FaultMessage e) { 
            System.out.println("Expected exception: faultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking updateAndRetrieveData...");
        com.cybershift.wfm3.mcs10.UpdateAndRetrieveData _updateAndRetrieveData_body = null;
        try {
            com.cybershift.wfm3.mcs10.ValueObjects _updateAndRetrieveData__return = port.updateAndRetrieveData(_updateAndRetrieveData_body);
            System.out.println("updateAndRetrieveData.result=" + _updateAndRetrieveData__return);

        } catch (FaultMessage e) { 
            System.out.println("Expected exception: faultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking processRequest...");
        com.cybershift.wfm3.mcs10.ValueObjects _processRequest_body = null;
        try {
            java.lang.String _processRequest__return = port.processRequest(_processRequest_body);
            System.out.println("processRequest.result=" + _processRequest__return);

        } catch (FaultMessage e) { 
            System.out.println("Expected exception: faultMessage has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking retrieveData...");
        com.cybershift.wfm3.mcs10.RetrieveData _retrieveData_body = null;
        try {
            com.cybershift.wfm3.mcs10.ValueObjects _retrieveData__return = port.retrieveData(_retrieveData_body);
            System.out.println("retrieveData.result=" + _retrieveData__return);

        } catch (FaultMessage e) { 
            System.out.println("Expected exception: faultMessage has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}