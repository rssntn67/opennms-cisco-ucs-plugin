package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IpPoolPoolable {
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;
    @JacksonXmlProperty(isAttribute = true)
    public int id;
    @JacksonXmlProperty(isAttribute = true)
    public String poolDn;
    @JacksonXmlProperty(isAttribute = true)
    public String rn;

    @Override
    public String toString() {
        return "IpPoolPollable{" +
                "childAction='" + childAction + '\'' +
                ", id=" + id +
                ", poolDn='" + poolDn + '\'' +
                ", rn='" + rn + '\'' +
                '}';
    }
}
