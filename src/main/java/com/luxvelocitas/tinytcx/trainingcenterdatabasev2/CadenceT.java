
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cadence_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cadence_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Target_t">
 *       &lt;sequence>
 *         &lt;element name="Low" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="High" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cadence_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "low",
    "high"
})
public class CadenceT
    extends TargetT
{

    @XmlElement(name = "Low", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected double low;
    @XmlElement(name = "High", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected double high;

    /**
     * Gets the value of the low property.
     * 
     */
    public double getLow() {
        return low;
    }

    /**
     * Sets the value of the low property.
     * 
     */
    public void setLow(double value) {
        this.low = value;
    }

    /**
     * Gets the value of the high property.
     * 
     */
    public double getHigh() {
        return high;
    }

    /**
     * Sets the value of the high property.
     * 
     */
    public void setHigh(double value) {
        this.high = value;
    }

}
