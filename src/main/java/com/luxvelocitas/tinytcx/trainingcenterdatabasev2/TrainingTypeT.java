
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TrainingType_t.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TrainingType_t">
 *   &lt;restriction base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Token_t">
 *     &lt;enumeration value="Workout"/>
 *     &lt;enumeration value="Course"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TrainingType_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
@XmlEnum
public enum TrainingTypeT {

    @XmlEnumValue("Workout")
    WORKOUT("Workout"),
    @XmlEnumValue("Course")
    COURSE("Course");
    private final String value;

    TrainingTypeT(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TrainingTypeT fromValue(String v) {
        for (TrainingTypeT c: TrainingTypeT.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
