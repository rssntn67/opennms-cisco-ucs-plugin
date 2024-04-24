package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaRefresh")
public class AaaRefreshResponse {
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AaaRefreshResponse{");
        sb.append("cookie='").append(cookie).append('\'');
        sb.append(", response='").append(response).append('\'');
        sb.append(", outCookie='").append(outCookie).append('\'');
        sb.append(", outRefreshPeriod=").append(outRefreshPeriod);
        sb.append(", outPriv='").append(outPriv).append('\'');
        sb.append(", outDomains='").append(outDomains).append('\'');
        sb.append(", outChannel='").append(outChannel).append('\'');
        sb.append(", outEvtChannel='").append(outEvtChannel).append('\'');
        sb.append(", outSessionId='").append(outSessionId).append('\'');
        sb.append(", outVersion='").append(outVersion).append('\'');
        sb.append(", outName='").append(outName).append('\'');
        sb.append(", outPasswdExpiryStatus='").append(outPasswdExpiryStatus).append('\'');
        sb.append(", outPasswdExpiryDuration=").append(outPasswdExpiryDuration);
        sb.append(", errorCode=").append(errorCode);
        sb.append(", errorDescr='").append(errorDescr).append('\'');
        sb.append(", invocationResult='").append(invocationResult).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


