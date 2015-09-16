
package com.cybershift.wfm3.mcs10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.cybershift.wfm3._5._3.WFM3ValueObject;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="businessObjectName" type="{http://www.cybershift.com/wfm3/5/3/}WFM3BusinessObjectName"/&gt;
 *         &lt;element name="queryValueObject" type="{http://www.cybershift.com/wfm3/5/3/}WFM3ValueObject"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "businessObjectName",
    "queryValueObject"
})
@XmlRootElement(name = "DeleteData")
public class DeleteData {

    @XmlElement(required = true)
    protected String businessObjectName;
    @XmlElement(required = true)
    protected WFM3ValueObject queryValueObject;

    /**
     * Gets the value of the businessObjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessObjectName() {
        return businessObjectName;
    }

    /**
     * Sets the value of the businessObjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessObjectName(String value) {
        this.businessObjectName = value;
    }

    /**
     * Gets the value of the queryValueObject property.
     * 
     * @return
     *     possible object is
     *     {@link WFM3ValueObject }
     *     
     */
    public WFM3ValueObject getQueryValueObject() {
        return queryValueObject;
    }

    /**
     * Sets the value of the queryValueObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link WFM3ValueObject }
     *     
     */
    public void setQueryValueObject(WFM3ValueObject value) {
        this.queryValueObject = value;
    }

}
