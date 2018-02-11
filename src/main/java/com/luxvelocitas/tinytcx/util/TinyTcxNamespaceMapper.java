package com.luxvelocitas.tinytcx.util;

import com.luxvelocitas.tinytcx.AbstractTinyTcx;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;


public class TinyTcxNamespaceMapper extends NamespacePrefixMapper {
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if (AbstractTinyTcx.TCX_NAMESPACE_URI.equals(namespaceUri)) {
            return "";
        }
        return suggestion;
    }

    @Override
    public String[] getPreDeclaredNamespaceUris() {
        return new String[] {
            AbstractTinyTcx.TCX_NAMESPACE_URI,
            "http://www.garmin.com/xmlschemas/ActivityExtension/v2",
            "http://www.garmin.com/xmlschemas/UserProfile/v2",
            "http://www.garmin.com/xmlschemas/ProfileExtension/v1",
            "http://www.garmin.com/xmlschemas/ActivityGoals/v1"
        };
    }
}

