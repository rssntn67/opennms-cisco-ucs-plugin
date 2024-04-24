package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogin")
public class AaaLoginResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;
    @JacksonXmlProperty(isAttribute = true)
    public String response;
    @JacksonXmlProperty(isAttribute = true)
    public String outCookie;
    @JacksonXmlProperty(isAttribute = true)
    public int outRefreshPeriod;
    @JacksonXmlProperty(isAttribute = true)
    public String outPriv;
    @JacksonXmlProperty(isAttribute = true)
    public String outDomains;
    @JacksonXmlProperty(isAttribute = true)
    public String outChannel;
    @JacksonXmlProperty(isAttribute = true)
    public String outEvtChannel;
    @JacksonXmlProperty(isAttribute = true)
    public String outSessionId;
    @JacksonXmlProperty(isAttribute = true)
    public String outVersion;
    @JacksonXmlProperty(isAttribute = true)
    public String outName;
    @JacksonXmlProperty(isAttribute = true)
    public String outPasswdExpiryStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int outPasswdExpiryDuration;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;
}
