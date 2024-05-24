package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalCompletionStats;

import java.util.List;

public class ConfigResolveClassResponseComputePCIeFatalCompletionStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputePCIeFatalCompletionStats> computePCIeFatalCompletionStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputePCIeFatalCompletionStats{" +
                "computePCIeFatalCompletionStats=" + computePCIeFatalCompletionStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
