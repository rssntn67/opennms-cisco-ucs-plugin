package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class DnResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String value;
}
