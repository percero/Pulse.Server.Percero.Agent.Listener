
package com.cybershift.wfm3._5._3;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cybershift.wfm3._5._3 package. 
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

    private final static QName _WFM3ValueObject_QNAME = new QName("http://www.cybershift.com/wfm3/5/3/", "WFM3ValueObject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cybershift.wfm3._5._3
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WFM3Map }
     * 
     */
    public WFM3Map createWFM3Map() {
        return new WFM3Map();
    }

    /**
     * Create an instance of {@link WFM3ValueObject }
     * 
     */
    public WFM3ValueObject createWFM3ValueObject() {
        return new WFM3ValueObject();
    }

    /**
     * Create an instance of {@link WFM3String }
     * 
     */
    public WFM3String createWFM3String() {
        return new WFM3String();
    }

    /**
     * Create an instance of {@link WFM3Double }
     * 
     */
    public WFM3Double createWFM3Double() {
        return new WFM3Double();
    }

    /**
     * Create an instance of {@link WFM3Integer }
     * 
     */
    public WFM3Integer createWFM3Integer() {
        return new WFM3Integer();
    }

    /**
     * Create an instance of {@link WFM3Decimal }
     * 
     */
    public WFM3Decimal createWFM3Decimal() {
        return new WFM3Decimal();
    }

    /**
     * Create an instance of {@link WFM3Date }
     * 
     */
    public WFM3Date createWFM3Date() {
        return new WFM3Date();
    }

    /**
     * Create an instance of {@link WFM3Time }
     * 
     */
    public WFM3Time createWFM3Time() {
        return new WFM3Time();
    }

    /**
     * Create an instance of {@link WFM3DateTime }
     * 
     */
    public WFM3DateTime createWFM3DateTime() {
        return new WFM3DateTime();
    }

    /**
     * Create an instance of {@link WFM3LongString }
     * 
     */
    public WFM3LongString createWFM3LongString() {
        return new WFM3LongString();
    }

    /**
     * Create an instance of {@link WFM3Collection }
     * 
     */
    public WFM3Collection createWFM3Collection() {
        return new WFM3Collection();
    }

    /**
     * Create an instance of {@link WFM3Object }
     * 
     */
    public WFM3Object createWFM3Object() {
        return new WFM3Object();
    }

    /**
     * Create an instance of {@link WFM3Map.Entry }
     * 
     */
    public WFM3Map.Entry createWFM3MapEntry() {
        return new WFM3Map.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WFM3ValueObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.cybershift.com/wfm3/5/3/", name = "WFM3ValueObject")
    public JAXBElement<WFM3ValueObject> createWFM3ValueObject(WFM3ValueObject value) {
        return new JAXBElement<WFM3ValueObject>(_WFM3ValueObject_QNAME, WFM3ValueObject.class, null, value);
    }

}
