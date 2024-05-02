package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IpPoolBlock {
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;
    @JacksonXmlProperty(isAttribute = true)
    public String defGw;
    @JacksonXmlProperty(isAttribute = true)
    public String from;
    @JacksonXmlProperty(isAttribute = true)
    public String primDns;
    @JacksonXmlProperty(isAttribute = true)
    public String rn;
    @JacksonXmlProperty(isAttribute = true)
    public String secDns;
    @JacksonXmlProperty(isAttribute = true)
    public String subnet;
    @JacksonXmlProperty(isAttribute = true)
    public String to;

    @Override
    public String toString() {
        return "IpPoolBlock{" +
                "childAction='" + childAction + '\'' +
                ", defGw='" + defGw + '\'' +
                ", from='" + from + '\'' +
                ", primDns='" + primDns + '\'' +
                ", rn='" + rn + '\'' +
                ", secDns='" + secDns + '\'' +
                ", subnet='" + subnet + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
