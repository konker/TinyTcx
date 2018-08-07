
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import java.time.ZonedDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.luxvelocitas.tinytcx.util.ZonedDateTimeXmlAdapter;


/**
 * <p>Java class for Trackpoint_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Trackpoint_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Position" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Position_t" minOccurs="0"/>
 *         &lt;element name="AltitudeMeters" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DistanceMeters" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="HeartRateBpm" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}HeartRateInBeatsPerMinute_t" minOccurs="0"/>
 *         &lt;element name="Cadence" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}CadenceValue_t" minOccurs="0"/>
 *         &lt;element name="SensorState" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}SensorState_t" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Extensions_t" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trackpoint_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", propOrder = {
    "time",
    "position",
    "altitudeMeters",
    "distanceMeters",
    "heartRateBpm",
    "cadence",
    "sensorState",
    "extensions"
})
public class TrackpointT {

    @XmlElement(name = "Time", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2", required = true, type = String.class)
    @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
    @XmlSchemaType(name = "dateTime")
    protected ZonedDateTime time;
    @XmlElement(name = "Position", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected PositionT position;
    @XmlElement(name = "AltitudeMeters", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected Double altitudeMeters;
    @XmlElement(name = "DistanceMeters", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected Double distanceMeters;
    @XmlElement(name = "HeartRateBpm", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected HeartRateInBeatsPerMinuteT heartRateBpm;
    @XmlElement(name = "Cadence", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    @XmlSchemaType(name = "unsignedByte")
    protected Short cadence;
    @XmlElement(name = "SensorState", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    @XmlSchemaType(name = "token")
    protected SensorStateT sensorState;
    @XmlElement(name = "Extensions", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
    protected ExtensionsT extensions;

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ZonedDateTime getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(ZonedDateTime value) {
        this.time = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link PositionT }
     *     
     */
    public PositionT getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionT }
     *     
     */
    public void setPosition(PositionT value) {
        this.position = value;
    }

    /**
     * Gets the value of the altitudeMeters property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAltitudeMeters() {
        return altitudeMeters;
    }

    /**
     * Sets the value of the altitudeMeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltitudeMeters(Double value) {
        this.altitudeMeters = value;
    }

    /**
     * Gets the value of the distanceMeters property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistanceMeters() {
        return distanceMeters;
    }

    /**
     * Sets the value of the distanceMeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistanceMeters(Double value) {
        this.distanceMeters = value;
    }

    /**
     * Gets the value of the heartRateBpm property.
     * 
     * @return
     *     possible object is
     *     {@link HeartRateInBeatsPerMinuteT }
     *     
     */
    public HeartRateInBeatsPerMinuteT getHeartRateBpm() {
        return heartRateBpm;
    }

    /**
     * Sets the value of the heartRateBpm property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeartRateInBeatsPerMinuteT }
     *     
     */
    public void setHeartRateBpm(HeartRateInBeatsPerMinuteT value) {
        this.heartRateBpm = value;
    }

    /**
     * Gets the value of the cadence property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getCadence() {
        return cadence;
    }

    /**
     * Sets the value of the cadence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setCadence(Short value) {
        this.cadence = value;
    }

    /**
     * Gets the value of the sensorState property.
     * 
     * @return
     *     possible object is
     *     {@link SensorStateT }
     *     
     */
    public SensorStateT getSensorState() {
        return sensorState;
    }

    /**
     * Sets the value of the sensorState property.
     * 
     * @param value
     *     allowed object is
     *     {@link SensorStateT }
     *     
     */
    public void setSensorState(SensorStateT value) {
        this.sensorState = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsT }
     *     
     */
    public ExtensionsT getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsT }
     *     
     */
    public void setExtensions(ExtensionsT value) {
        this.extensions = value;
    }

}
