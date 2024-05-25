package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentFanStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentFanStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentFanStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentFanStats{" +
                "equipmentFanStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
