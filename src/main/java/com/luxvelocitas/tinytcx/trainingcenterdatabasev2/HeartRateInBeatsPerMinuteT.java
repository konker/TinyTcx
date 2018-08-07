
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeartRateInBeatsPerMinute_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeartRateInBeatsPerMinute_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateValue_t">
 *       &lt;sequence>
 *         &lt;element name="Value" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}positiveByte"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeartRateInBeatsPerMinute_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "value"
})
public class HeartRateInBeatsPerMinuteT
    extends HeartRateValueT
{

    @XmlElement(name = "Value", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    @XmlSchemaType(name = "unsignedByte")
    protected short value;

    /**
     * Gets the value of the value property.
     * 
     */
    public short getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(short value) {
        this.value = value;
    }

}
