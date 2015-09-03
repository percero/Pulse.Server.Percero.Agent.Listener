
package com.cybershift.wfm3.mcs10;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="valueObject" type="{http://www.cybershift.com/wfm3/5/3/}WFM3ValueObject" maxOccurs="unbounded"/&gt;
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
    "valueObject"
})
@XmlRootElement(name = "ValueObjects")
public class ValueObjects {

    @XmlElement(required = true)
    protected List<WFM3ValueObject> valueObject;

    /**
     * Gets the value of the valueObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WFM3ValueObject }
     * 
     * 
     */
    public List<WFM3ValueObject> getValueObject() {
        if (valueObject == null) {
            valueObject = new ArrayList<WFM3ValueObject>();
        }
        return this.valueObject;
    }

}
