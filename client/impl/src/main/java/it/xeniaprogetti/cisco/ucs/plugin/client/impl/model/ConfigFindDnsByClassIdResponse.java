package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "configFindDnsByClassId")
public class ConfigFindDnsByClassIdResponse {
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
    @JacksonXmlCData
    public List<DistinguishedName> outDns;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ConfigFindDnsByClassIdResponse{");
        sb.append("cookie='").append(cookie).append('\'');
        sb.append(", response='").append(response).append('\'');
        sb.append(", errorCode=").append(errorCode);
        sb.append(", errorDescr='").append(errorDescr).append('\'');
        sb.append(", invocationResult='").append(invocationResult).append('\'');
        sb.append(", classId='").append(classId).append('\'');
        sb.append(", outDns=").append(outDns);
        sb.append('}');
        return sb.toString();
    }


}
