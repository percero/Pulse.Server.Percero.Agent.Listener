
package com.cybershift.wfm3._5._3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WFM3Collection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WFM3Collection"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.cybershift.com/wfm3/5/3/}WFM3Attribute"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="valueObject" type="{http://www.cybershift.com/wfm3/5/3/}WFM3ValueObject" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WFM3Collection", propOrder = {
    "valueObject"
})
public class WFM3Collection
    extends WFM3Attribute
{

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
