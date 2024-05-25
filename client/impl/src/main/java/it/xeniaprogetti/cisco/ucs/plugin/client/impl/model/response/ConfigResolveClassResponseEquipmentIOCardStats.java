package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentIOCardStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentIOCardStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentIOCardStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentIOCardStats{" +
                "equipmentIOCardStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
