package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;

public class ConfigResolveDnResponseEquipmentChassis extends ConfigResolveDnResponse {

    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveEquipmentChassisDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", dn='" + dn + '\'' +
                ", outconfig=" + outconfig.equipmentChassis +
                '}';
    }

    public static class OutConfig {
        public EquipmentChassis equipmentChassis;
    }
}
