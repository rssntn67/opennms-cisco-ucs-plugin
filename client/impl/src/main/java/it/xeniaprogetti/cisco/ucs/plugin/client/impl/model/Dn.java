package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String value;

    @Override
    public String toString() {
        return "Dn{" + "value='" + value + '\'' +
                '}';
    }
}
