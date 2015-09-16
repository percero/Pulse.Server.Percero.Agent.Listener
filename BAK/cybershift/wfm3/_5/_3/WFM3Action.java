
package com.cybershift.wfm3._5._3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WFM3Action.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WFM3Action"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ADD"/&gt;
 *     &lt;enumeration value="UPDATE"/&gt;
 *     &lt;enumeration value="ADD_OR_UPDATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WFM3Action")
@XmlEnum
public enum WFM3Action {

    ADD,
    UPDATE,
    ADD_OR_UPDATE;

    public String value() {
        return name();
    }

    public static WFM3Action fromValue(String v) {
        return valueOf(v);
    }

}
