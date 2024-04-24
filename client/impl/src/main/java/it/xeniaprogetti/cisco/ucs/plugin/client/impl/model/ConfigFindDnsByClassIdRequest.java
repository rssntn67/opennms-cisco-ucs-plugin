package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configFindDnsByClassId")
public class ConfigFindDnsByClassIdRequest {
    @JacksonXmlProperty(isAttribute = true)
    public String classId;
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ConfigFindDnsByClassIdRequest{");
        sb.append("classId='").append(classId).append('\'');
        sb.append(", cookie='").append(cookie).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
