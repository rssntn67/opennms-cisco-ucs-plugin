package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class IpPoolAddr {
    @JacksonXmlProperty()
    public IpPoolPoolable ippoolPoolable;
    @JacksonXmlProperty(isAttribute = true)
    public String assigned;
    @JacksonXmlProperty(isAttribute = true)
    public String assignedToDn;
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;
    @JacksonXmlProperty(isAttribute = true)
    public int globalAssignedCnt;
    @JacksonXmlProperty(isAttribute = true)
    public int globalDefinedCnt;
    @JacksonXmlProperty(isAttribute = true)
    public String id;
    @JacksonXmlProperty(isAttribute = true)
    public String owner;
    @JacksonXmlProperty(isAttribute = true)
    public String rn;

    @Override
    public String toString() {
        return "IpPoolAddr{" +
                "ippoolPoolable=" + ippoolPoolable +
                ", assigned='" + assigned + '\'' +
                ", assignedToDn='" + assignedToDn + '\'' +
                ", childAction='" + childAction + '\'' +
                ", globalAssignedCnt=" + globalAssignedCnt +
                ", globalDefinedCnt=" + globalDefinedCnt +
                ", id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", rn='" + rn + '\'' +
                '}';
    }
}
