
package com.cybershift.wfm3._5._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WFM3LongString complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WFM3LongString"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.cybershift.com/wfm3/5/3/}WFM3Attribute"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="longString" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WFM3LongString", propOrder = {
    "longString"
})
public class WFM3LongString
    extends WFM3Attribute
{

    @XmlElement(required = true)
    protected String longString;

    /**
     * Gets the value of the longString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongString() {
        return longString;
    }

    /**
     * Sets the value of the longString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongString(String value) {
        this.longString = value;
    }

}
