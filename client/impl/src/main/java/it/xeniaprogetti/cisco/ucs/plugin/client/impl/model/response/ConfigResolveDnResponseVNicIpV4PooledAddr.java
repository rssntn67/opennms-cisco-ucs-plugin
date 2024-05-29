package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.VNicIpV4PooledAddr;

public class ConfigResolveDnResponseVNicIpV4PooledAddr extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveNetworkElementDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.vnicIpV4PooledAddr +
                '}';
    }

    public static class OutConfig {
        public VNicIpV4PooledAddr vnicIpV4PooledAddr;
    }
}
