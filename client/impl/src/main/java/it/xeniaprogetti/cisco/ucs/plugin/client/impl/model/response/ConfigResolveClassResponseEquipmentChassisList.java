package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;

import java.util.List;

public class ConfigResolveClassResponseEquipmentChassisList extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentChassis> equipmentChasses;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentChassisList{" +
                "equipmentChasses=" + equipmentChasses +
                ", classId='" + classId + '\'' +
                '}';
    }
}
