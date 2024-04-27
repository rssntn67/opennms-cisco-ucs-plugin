package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

@JacksonXmlRootElement(localName = "configResolveDn")
public abstract class ConfigResolveDnResponse extends UcsXmlApiResponse {
    @JacksonXmlProperty(isAttribute = true)
    public String dn;

}
