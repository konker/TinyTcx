
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sport_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Sport_t">
 *   &lt;restriction base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Token_t">
 *     &lt;enumeration value="Running"/>
 *     &lt;enumeration value="Biking"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Sport_t")
@XmlEnum
public enum SportT {

    @XmlEnumValue("Running")
    RUNNING("Running"),
    @XmlEnumValue("Biking")
    BIKING("Biking"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    SportT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SportT fromValue(String v) {
        for (SportT c: SportT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
