
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Target_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Target_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Target_t", namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2")
@XmlSeeAlso({
    NoneT.class,
    HeartRateT.class,
    SpeedT.class,
    CadenceT.class
})
public abstract class TargetT {


}
