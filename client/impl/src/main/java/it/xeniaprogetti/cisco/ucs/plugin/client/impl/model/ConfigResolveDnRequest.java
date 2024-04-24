package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "configResolveDn")
public class ConfigResolveDnRequest {
    @JacksonXmlProperty(isAttribute = true)
    private final String dn;

    @JacksonXmlProperty(isAttribute = true)
    private final String cookie;

    @JacksonXmlProperty(isAttribute = true)
    private final boolean inHierarchical;

    public ConfigResolveDnRequest(String dn, String cookie, boolean inHierarchical) {
        this.dn = dn;
        this.cookie = cookie;
        this.inHierarchical = inHierarchical;
    }
}
