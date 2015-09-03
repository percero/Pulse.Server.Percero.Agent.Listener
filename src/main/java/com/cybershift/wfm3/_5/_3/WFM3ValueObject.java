
package com.cybershift.wfm3._5._3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WFM3ValueObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WFM3ValueObject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="StringAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3String"/&gt;
 *         &lt;element name="DoubleAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Double"/&gt;
 *         &lt;element name="IntegerAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Integer"/&gt;
 *         &lt;element name="DecimalAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Decimal"/&gt;
 *         &lt;element name="DateAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Date"/&gt;
 *         &lt;element name="TimeAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Time"/&gt;
 *         &lt;element name="DateTimeAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3DateTime"/&gt;
 *         &lt;element name="LongStringAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3LongString"/&gt;
 *         &lt;element name="CollectionAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Collection"/&gt;
 *         &lt;element name="MapAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Map"/&gt;
 *         &lt;element name="ObjectAttribute" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Object"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="action" type="{http://www.cybershift.com/wfm3/5/3/}WFM3Action" /&gt;
 *       &lt;attribute name="pageNumber" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="pageSize" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="payroll" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="startDate" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *       &lt;attribute name="endDate" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WFM3ValueObject", propOrder = {
    "stringAttributeOrDoubleAttributeOrIntegerAttribute"
})
public class WFM3ValueObject {

    @XmlElements({
        @XmlElement(name = "StringAttribute", type = WFM3String.class),
        @XmlElement(name = "DoubleAttribute", type = WFM3Double.class),
        @XmlElement(name = "IntegerAttribute", type = WFM3Integer.class),
        @XmlElement(name = "DecimalAttribute", type = WFM3Decimal.class),
        @XmlElement(name = "DateAttribute", type = WFM3Date.class),
        @XmlElement(name = "TimeAttribute", type = WFM3Time.class),
        @XmlElement(name = "DateTimeAttribute", type = WFM3DateTime.class),
        @XmlElement(name = "LongStringAttribute", type = WFM3LongString.class),
        @XmlElement(name = "CollectionAttribute", type = WFM3Collection.class),
        @XmlElement(name = "MapAttribute", type = WFM3Map.class),
        @XmlElement(name = "ObjectAttribute", type = WFM3Object.class)
    })
    protected List<WFM3Attribute> stringAttributeOrDoubleAttributeOrIntegerAttribute;
    @XmlAttribute(name = "action")
    protected WFM3Action action;
    @XmlAttribute(name = "pageNumber")
    protected BigInteger pageNumber;
    @XmlAttribute(name = "pageSize")
    protected BigInteger pageSize;
    @XmlAttribute(name = "payroll")
    protected String payroll;
    @XmlAttribute(name = "startDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "endDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the stringAttributeOrDoubleAttributeOrIntegerAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stringAttributeOrDoubleAttributeOrIntegerAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStringAttributeOrDoubleAttributeOrIntegerAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WFM3String }
     * {@link WFM3Double }
     * {@link WFM3Integer }
     * {@link WFM3Decimal }
     * {@link WFM3Date }
     * {@link WFM3Time }
     * {@link WFM3DateTime }
     * {@link WFM3LongString }
     * {@link WFM3Collection }
     * {@link WFM3Map }
     * {@link WFM3Object }
     * 
     * 
     */
    public List<WFM3Attribute> getStringAttributeOrDoubleAttributeOrIntegerAttribute() {
        if (stringAttributeOrDoubleAttributeOrIntegerAttribute == null) {
            stringAttributeOrDoubleAttributeOrIntegerAttribute = new ArrayList<WFM3Attribute>();
        }
        return this.stringAttributeOrDoubleAttributeOrIntegerAttribute;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link WFM3Action }
     *     
     */
    public WFM3Action getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link WFM3Action }
     *     
     */
    public void setAction(WFM3Action value) {
        this.action = value;
    }

    /**
     * Gets the value of the pageNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets the value of the pageNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageNumber(BigInteger value) {
        this.pageNumber = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPageSize(BigInteger value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the payroll property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayroll() {
        return payroll;
    }

    /**
     * Sets the value of the payroll property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayroll(String value) {
        this.payroll = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
