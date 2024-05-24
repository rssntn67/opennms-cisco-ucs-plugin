package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;

import java.util.List;

public class ConfigResolveClassResponseComputeBlade extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputeBlade> computeBlades;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputeBladeList{" +
                "computeBlades=" + computeBlades +
                ", classId='" + classId + '\'' +
                '}';
    }
}
