
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Speed_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Speed_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Target_t">
 *       &lt;sequence>
 *         &lt;element name="SpeedZone" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Speed_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "speedZone"
})
public class SpeedT
    extends TargetT
{

    @XmlElement(name = "SpeedZone", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", required = true)
    protected ZoneT speedZone;

    /**
     * Gets the value of the speedZone property.
     * 
     * @return
     *     possible object is
     *     {@link ZoneT }
     *     
     */
    public ZoneT getSpeedZone() {
        return speedZone;
    }

    /**
     * Sets the value of the speedZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoneT }
     *     
     */
    public void setSpeedZone(ZoneT value) {
        this.speedZone = value;
    }

}
