package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentNetworkElementFanStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentNetworkElementFanStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentNetworkElementFanStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentNetworkElementFanStats{" +
                "equipmentNetworkElementFanStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
