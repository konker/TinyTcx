
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Courses_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Courses_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CourseFolder" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}CourseFolder_t"/>
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
@XmlType(name = "Courses_t", propOrder = {
    "courseFolder",
    "extensions"
})
public class CoursesT {

    @XmlElement(name = "CourseFolder", required = true)
    protected CourseFolderT courseFolder;
    @XmlElement(name = "Extensions")
    protected ExtensionsT extensions;

    /**
     * Gets the value of the courseFolder property.
     * 
     * @return
     *     possible object is
     *     {@link CourseFolderT }
     *     
     */
    public CourseFolderT getCourseFolder() {
        return courseFolder;
    }

    /**
     * Sets the value of the courseFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseFolderT }
     *     
     */
    public void setCourseFolder(CourseFolderT value) {
        this.courseFolder = value;
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