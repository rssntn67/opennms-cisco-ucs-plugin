package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

import java.util.List;

@JacksonXmlRootElement(localName = "configResolveClass")
public class ConfigResolveClassResponse<T extends UcsElement> extends UcsXmlApiResponse {
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
    @JacksonXmlProperty(isAttribute = true)
    public String classId;

    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<T> ucsElements;

    @Override
    public String toString() {
        return "ConfigResolveDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", errorCode=" + errorCode +
                ", errorDescr='" + errorDescr + '\'' +
                ", invocationResult='" + invocationResult + '\'' +
                ", classId='" + classId + '\'' +
                ", ucsElements=" + ucsElements +
                '}';
    }
}
