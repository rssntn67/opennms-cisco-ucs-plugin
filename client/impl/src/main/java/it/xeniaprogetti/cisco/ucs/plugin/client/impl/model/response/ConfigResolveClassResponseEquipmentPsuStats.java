package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentPsuStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentPsuStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentPsuStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentPsuStats{" +
                "equipmentPsuStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
