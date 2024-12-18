package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentFanModuleStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentFanModuleStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentFanModuleStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentFanModuleStats{" +
                "equipmentFanModuleStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
