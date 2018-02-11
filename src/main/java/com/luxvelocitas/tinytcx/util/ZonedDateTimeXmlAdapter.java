package com.luxvelocitas.tinytcx.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class ZonedDateTimeXmlAdapter extends XmlAdapter<String, ZonedDateTime> {
    @Override
    public String marshal(ZonedDateTime arg) {
        return arg.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    @Override
    public ZonedDateTime unmarshal(String arg) {
        return ZonedDateTime.parse(arg, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}