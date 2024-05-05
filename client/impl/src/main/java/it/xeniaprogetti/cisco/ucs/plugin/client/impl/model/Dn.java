package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
}
