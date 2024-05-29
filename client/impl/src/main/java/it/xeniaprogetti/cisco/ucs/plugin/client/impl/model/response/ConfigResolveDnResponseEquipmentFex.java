package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;

public class ConfigResolveDnResponseEquipmentFex extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveEquipmentFexDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.equipmentFex +
                '}';
    }

    public static class OutConfig {
        public EquipmentFex equipmentFex;
    }
}
