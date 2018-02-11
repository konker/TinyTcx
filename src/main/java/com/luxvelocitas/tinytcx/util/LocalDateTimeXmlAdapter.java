package com.luxvelocitas.tinytcx.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public String marshal(LocalDateTime arg) {
        return arg.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public LocalDateTime unmarshal(String arg) {
        return LocalDateTime.parse(arg, DateTimeFormatter.ISO_DATE_TIME);
    }
}