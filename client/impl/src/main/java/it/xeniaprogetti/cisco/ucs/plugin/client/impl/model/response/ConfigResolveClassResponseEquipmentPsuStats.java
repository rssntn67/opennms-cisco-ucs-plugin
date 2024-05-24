package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentPsuStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentPsuStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentPsuStats> equipmentPsuStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentPsuStats{" +
                "equipmentPsuStats=" + equipmentPsuStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
