package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configResolveDn")
public abstract class ConfigResolveDnResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String dn;

}
