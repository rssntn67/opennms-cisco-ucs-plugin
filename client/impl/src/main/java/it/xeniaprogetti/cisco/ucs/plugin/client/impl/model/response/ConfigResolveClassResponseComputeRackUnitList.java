package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;

import java.util.List;

public class ConfigResolveClassResponseComputeRackUnitList extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputeRackUnit> computeRackUnits;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputeRackUnitList{" +
                "computeRackUnits=" + computeRackUnits +
                ", classId='" + classId + '\'' +
                '}';
    }
}
