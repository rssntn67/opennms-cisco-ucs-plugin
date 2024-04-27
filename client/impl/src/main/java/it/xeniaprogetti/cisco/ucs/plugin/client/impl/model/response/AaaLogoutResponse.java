package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogout")
public class AaaLogoutResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String outStatus;

    @Override
    public String toString() {
        return "AaaLogoutResponse{" + "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", outStatus='" + outStatus + '\'' +
                ", errorCode=" + errorCode +
                ", errorDescr='" + errorDescr + '\'' +
                ", invocationResult='" + invocationResult + '\'' +
                '}';
    }
}
