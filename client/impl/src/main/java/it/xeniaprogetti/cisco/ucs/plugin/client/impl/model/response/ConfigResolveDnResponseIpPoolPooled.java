package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.VNicIpV4PooledAddr;

public class ConfigResolveDnResponseIpPoolPooled extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveNetworkElementDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.ippoolPooled +
                '}';
    }

    public static class OutConfig {
        public IpPoolPooled ippoolPooled;
    }
}
