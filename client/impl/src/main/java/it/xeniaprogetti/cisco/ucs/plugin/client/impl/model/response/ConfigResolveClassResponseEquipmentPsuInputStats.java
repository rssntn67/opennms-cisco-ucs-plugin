package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentPsuInputStats;

import java.util.List;

public class ConfigResolveClassResponseEquipmentPsuInputStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentPsuInputStats> equipmentPsuInputStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentPsuInputStats{" +
                "equipmentPsuInputStats=" + equipmentPsuInputStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
