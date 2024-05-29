package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaRefresh")
public class AaaRefreshResponse extends UcsXmlApiResponse {
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

    @Override
    public String toString() {
        return "AaaRefreshResponse{" + "cookie='" + cookie + '\'' +
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
                '}';
    }
}


