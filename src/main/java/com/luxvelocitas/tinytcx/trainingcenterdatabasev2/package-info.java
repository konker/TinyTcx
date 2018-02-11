@javax.xml.bind.annotation.XmlSchema(
        namespace = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2",
        xmlns={@XmlNs(prefix="tcx",
                namespaceURI="http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2"),
                @XmlNs(prefix="ns2",
                        namespaceURI="http://www.garmin.com/xmlschemas/ActivityExtension/v2"),
                @XmlNs(prefix="ns3",
                        namespaceURI="http://www.garmin.com/xmlschemas/UserProfile/v2"),
                @XmlNs(prefix="ns4",
                        namespaceURI="http://www.garmin.com/xmlschemas/ProfileExtension/v1"),
                @XmlNs(prefix="ns5",
                        namespaceURI="http://www.garmin.com/xmlschemas/ActivityGoals/v1")},
        elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
package com.luxvelocitas.tinytcx.trainingcenterdatabasev2;

import javax.xml.bind.annotation.XmlNs;