package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogout")
public class AaaLogoutResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String outStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;

    @Override
    public String toString() {
        return "AaaLogoutResponse{" + "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", outStatus='" + outStatus + '\'' +
                ", errorCode=" + errorCode +
                ", invocationResult=" + invocationResult +
                ", errorDescr=" + errorDescr +

                '}';
    }
}
