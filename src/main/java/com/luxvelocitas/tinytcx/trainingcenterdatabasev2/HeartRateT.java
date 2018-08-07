
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeartRate_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeartRate_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Target_t">
 *       &lt;sequence>
 *         &lt;element name="HeartRateZone" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeartRate_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "heartRateZone"
})
public class HeartRateT
    extends TargetT
{

    @XmlElement(name = "HeartRateZone", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", required = true)
    protected ZoneT heartRateZone;

    /**
     * Gets the value of the heartRateZone property.
     * 
     * @return
     *     possible object is
     *     {@link ZoneT }
     *     
     */
    public ZoneT getHeartRateZone() {
        return heartRateZone;
    }

    /**
     * Sets the value of the heartRateZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoneT }
     *     
     */
    public void setHeartRateZone(ZoneT value) {
        this.heartRateZone = value;
    }

}
