
package com.cybershift.wfm3.mcs10;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cybershift.wfm3.mcs10 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeletedObjectCount_QNAME = new QName("http://www.cybershift.com/wfm3/mcs10/", "DeletedObjectCount");
    private final static QName _OperationResult_QNAME = new QName("http://www.cybershift.com/wfm3/mcs10/", "OperationResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cybershift.wfm3.mcs10
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrieveData }
     * 
     */
    public RetrieveData createRetrieveData() {
        return new RetrieveData();
    }

    /**
     * Create an instance of {@link UpdateAndRetrieveData }
     * 
     */
    public UpdateAndRetrieveData createUpdateAndRetrieveData() {
        return new UpdateAndRetrieveData();
    }

    /**
     * Create an instance of {@link DeleteData }
     * 
     */
    public DeleteData createDeleteData() {
        return new DeleteData();
    }

    /**
     * Create an instance of {@link ValueObjects }
     * 
     */
    public ValueObjects createValueObjects() {
        return new ValueObjects();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link UsernameToken }
     * 
     */
    public UsernameToken createUsernameToken() {
        return new UsernameToken();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cybershift.com/wfm3/mcs10/", name = "DeletedObjectCount")
    public JAXBElement<BigInteger> createDeletedObjectCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_DeletedObjectCount_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cybershift.com/wfm3/mcs10/", name = "OperationResult")
    public JAXBElement<String> createOperationResult(String value) {
        return new JAXBElement<String>(_OperationResult_QNAME, String.class, null, value);
    }

}
