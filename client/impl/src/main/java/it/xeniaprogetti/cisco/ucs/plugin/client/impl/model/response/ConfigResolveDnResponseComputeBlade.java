package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;

public class ConfigResolveDnResponseComputeBlade extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveComputeBladeDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.computeBlade +
                '}';
    }

    public static class OutConfig {
        public ComputeBlade computeBlade;
    }
}
