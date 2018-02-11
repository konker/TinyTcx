package com.luxvelocitas.tinytcx;

import com.luxvelocitas.tinytcx.trainingcenterdatabasev2.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


public abstract class AbstractTinyTcx {
    public static final String TCX_PACKAGE = "com.luxvelocitas.tinytcx.trainingcenterdatabasev2";
    public static final String TCX_NAMESPACE_URI = "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2";
    public static final String TCX_SCHEMA_LOCATION =
            "http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2 http://www.garmin.com/xmlschemas/TrainingCenterDatabasev2.xsd";


    protected TrainingCenterDatabaseT database;
    protected JAXBContext jaxbContext;


    /**
     * [TODO: Comments]
     *
     * @throws JAXBException
     */
    protected AbstractTinyTcx() throws JAXBException, javax.xml.bind.JAXBException {
        this.jaxbContext = JAXBContext.newInstance(TCX_PACKAGE);
    }

    /**
     * [TODO: Comments]
     *
     * @return
     */
    public TrainingCenterDatabaseT getDatabase() {
        return this.database;
    }
}
