package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IpPoolPooled {
    @JacksonXmlProperty(isAttribute = true)
    public String assigned;
    @JacksonXmlProperty(isAttribute = true)
    public String assignedToDn;
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;
    @JacksonXmlProperty(isAttribute = true)
    public String defGw;
    @JacksonXmlProperty(isAttribute = true)
    public String id;
    @JacksonXmlProperty(isAttribute = true)
    public String poolableDn;
    @JacksonXmlProperty(isAttribute = true)
    public String prevAssignedToDn;
    @JacksonXmlProperty(isAttribute = true)
    public String primDns;
    @JacksonXmlProperty(isAttribute = true)
    public String rn;
    @JacksonXmlProperty(isAttribute = true)
    public String secDns;
    @JacksonXmlProperty(isAttribute = true)
    public String subnet;

    @Override
    public String toString() {
        return "IpPoolPooled{" +
                "assigned='" + assigned + '\'' +
                ", assignedToDn='" + assignedToDn + '\'' +
                ", childAction='" + childAction + '\'' +
                ", defGw='" + defGw + '\'' +
                ", id='" + id + '\'' +
                ", poolableDn='" + poolableDn + '\'' +
                ", prevAssignedToDn='" + prevAssignedToDn + '\'' +
                ", primDns='" + primDns + '\'' +
                ", rn='" + rn + '\'' +
                ", secDns='" + secDns + '\'' +
                ", subnet='" + subnet + '\'' +
                '}';
    }
}

