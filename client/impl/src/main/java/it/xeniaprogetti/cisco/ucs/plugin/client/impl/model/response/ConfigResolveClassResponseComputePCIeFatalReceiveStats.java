package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalReceiveStats;

import java.util.List;

public class ConfigResolveClassResponseComputePCIeFatalReceiveStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputePCIeFatalReceiveStats> computePCIeFatalReceiveStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputePCIeFatalReceiveStats{" +
                "computePCIeFatalReceiveStats=" + computePCIeFatalReceiveStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
