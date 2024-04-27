package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;

import java.util.List;

public class ConfigResolveClassResponseEquipmentRackEnclosureList extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentRackEnclosure> equipmentRackEnclosures;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentRackEnclosureList{" +
                "equipmentRackEnclosures=" + equipmentRackEnclosures +
                ", classId='" + classId + '\'' +
                '}';
    }
}
