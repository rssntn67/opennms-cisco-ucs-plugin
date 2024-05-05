package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configResolveClass")
public abstract class ConfigResolveClassResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String classId;

}
