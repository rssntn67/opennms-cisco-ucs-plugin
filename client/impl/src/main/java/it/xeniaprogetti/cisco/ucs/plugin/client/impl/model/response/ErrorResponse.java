package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "error")
public class ErrorResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;
    @JacksonXmlProperty(isAttribute = true)
    public String response;
    @JacksonXmlProperty(isAttribute = true)
    public String errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public int invocationResult;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", invocationResult=" + invocationResult +
                ", errorDescr='" + errorDescr + '\'' +
                '}';
    }
}
