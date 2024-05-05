package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;

import java.util.List;

public class IpPoolUniverse extends Dn {
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<IpPoolAddr> ippoolAddr;
    @JacksonXmlProperty(isAttribute = true)
    public String childAction;

    @Override
    public String toString() {
        return "IpPoolUniverse{" +
                "ippoolAddr=" + ippoolAddr +
                ", childAction='" + childAction + '\'' +
                ", dn='" + dn + '\'' +
                '}';
    }
}
