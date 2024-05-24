package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalStats;

import java.util.List;

public class ConfigResolveClassResponseComputePCIeFatalStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputePCIeFatalStats> computePCIeFatalStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputePCIeFatalStats{" +
                "computePCIeFatalStats=" + computePCIeFatalStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
