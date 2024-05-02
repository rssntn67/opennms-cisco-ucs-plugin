package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class VNicIpV4PooledAddr {
    @JacksonXmlProperty(isAttribute = true)
    public String addr;
    @JacksonXmlProperty(isAttribute = true)
    public String defGw;
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
    @JacksonXmlProperty(isAttribute = true)
    public String name;
    @JacksonXmlProperty(isAttribute = true)
    public String operName;
    @JacksonXmlProperty(isAttribute = true)
    public String primDns;
    @JacksonXmlProperty(isAttribute = true)
    public String secDns;
    @JacksonXmlProperty(isAttribute = true)
    public String subnet;
}
