package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;

import java.util.List;

public class ConfigResolveClassResponseEquipmentFexList extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EquipmentFex> equipmentFexes;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEquipmentFexList{" +
                "equipmentFexes=" + equipmentFexes +
                ", classId='" + classId + '\'' +
                '}';
    }
}
