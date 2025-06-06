package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogin")
public class AaaLoginResponse extends UcsXmlApiResponse {
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
    public long outPasswdExpiryDuration;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;

    @Override
    public String toString() {
        return "AaaLoginResponse{" + "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", outCookie='" + outCookie + '\'' +
                ", outRefreshPeriod=" + outRefreshPeriod +
                ", outPriv='" + outPriv + '\'' +
                ", outDomains='" + outDomains + '\'' +
                ", outChannel='" + outChannel + '\'' +
                ", outEvtChannel='" + outEvtChannel + '\'' +
                ", outSessionId='" + outSessionId + '\'' +
                ", outVersion='" + outVersion + '\'' +
                ", outName='" + outName + '\'' +
                ", outPasswdExpiryStatus='" + outPasswdExpiryStatus + '\'' +
                ", outPasswdExpiryDuration=" + outPasswdExpiryDuration +
                ", errorCode=" + errorCode +
                ", invocationResult=" + invocationResult +
                ", errorDescr=" + errorDescr +
                '}';
    }
}
