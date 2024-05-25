package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentChassisStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentChassisStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentChassisStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentChassisStats{" +
                "equipmentChassisStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
