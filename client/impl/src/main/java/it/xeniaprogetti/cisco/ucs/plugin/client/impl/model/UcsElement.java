package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class UcsElement {
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
}
