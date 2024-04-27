package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public abstract class UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;
    @JacksonXmlProperty(isAttribute = true)
    public String response;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;
}
