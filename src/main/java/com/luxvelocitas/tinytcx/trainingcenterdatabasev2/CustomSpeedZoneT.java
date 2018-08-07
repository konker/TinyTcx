
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomSpeedZone_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomSpeedZone_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t">
 *       &lt;sequence>
 *         &lt;element name="ViewAs" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}SpeedType_t"/>
 *         &lt;element name="LowInMetersPerSecond" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}SpeedInMetersPerSecond_t"/>
 *         &lt;element name="HighInMetersPerSecond" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}SpeedInMetersPerSecond_t"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomSpeedZone_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "viewAs",
    "lowInMetersPerSecond",
    "highInMetersPerSecond"
})
public class CustomSpeedZoneT
    extends ZoneT
{

    @XmlElement(name = "ViewAs", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", required = true)
    @XmlSchemaType(name = "token")
    protected SpeedTypeT viewAs;
    @XmlElement(name = "LowInMetersPerSecond", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected double lowInMetersPerSecond;
    @XmlElement(name = "HighInMetersPerSecond", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected double highInMetersPerSecond;

    /**
     * Gets the value of the viewAs property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedTypeT }
     *     
     */
    public SpeedTypeT getViewAs() {
        return viewAs;
    }

    /**
     * Sets the value of the viewAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedTypeT }
     *     
     */
    public void setViewAs(SpeedTypeT value) {
        this.viewAs = value;
    }

    /**
     * Gets the value of the lowInMetersPerSecond property.
     * 
     */
    public double getLowInMetersPerSecond() {
        return lowInMetersPerSecond;
    }

    /**
     * Sets the value of the lowInMetersPerSecond property.
     * 
     */
    public void setLowInMetersPerSecond(double value) {
        this.lowInMetersPerSecond = value;
    }

    /**
     * Gets the value of the highInMetersPerSecond property.
     * 
     */
    public double getHighInMetersPerSecond() {
        return highInMetersPerSecond;
    }

    /**
     * Sets the value of the highInMetersPerSecond property.
     * 
     */
    public void setHighInMetersPerSecond(double value) {
        this.highInMetersPerSecond = value;
    }

}
