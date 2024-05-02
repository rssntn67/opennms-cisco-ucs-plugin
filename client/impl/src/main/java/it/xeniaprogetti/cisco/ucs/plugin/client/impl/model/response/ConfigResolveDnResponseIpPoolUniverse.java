package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;

public class ConfigResolveDnResponseIpPoolUniverse extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveNetworkElementDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", errorCode=" + errorCode +
                ", errorDescr='" + errorDescr + '\'' +
                ", invocationResult='" + invocationResult + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.ippoolUniverse +
                '}';
    }

    public static class OutConfig {
        public IpPoolUniverse ippoolUniverse;
    }
}
