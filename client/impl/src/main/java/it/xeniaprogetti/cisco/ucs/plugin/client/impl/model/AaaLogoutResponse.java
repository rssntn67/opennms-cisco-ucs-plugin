package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogout")
public class AaaLogoutResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;
    @JacksonXmlProperty(isAttribute = true)
    public String response;
    @JacksonXmlProperty(isAttribute = true)
    public String outStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AaaLogoutResponse{");
        sb.append("cookie='").append(cookie).append('\'');
        sb.append(", response='").append(response).append('\'');
        sb.append(", outStatus='").append(outStatus).append('\'');
        sb.append(", errorCode=").append(errorCode);
        sb.append(", errorDescr='").append(errorDescr).append('\'');
        sb.append(", invocationResult='").append(invocationResult).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
