package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "configFindDnsByClassId")
public class ConfigFindDnsByClassIdResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String classId;
    @JacksonXmlElementWrapper(localName = "outDns")
    public List<DnResponse> dns;

    @Override
    public String toString() {
        return "ConfigFindDnsByClassIdResponse{" + "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", classId='" + classId + '\'' +
                ", dns=" + dns +
                '}';
    }


}
