package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalProtocolStats;

import java.util.List;

public class ConfigResolveClassResponseComputePCIeFatalProtocolStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputePCIeFatalProtocolStats> computePCIeFatalProtocolStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputePCIeFatalProtocolStats{" +
                "computePCIeFatalProtocolStats=" + computePCIeFatalProtocolStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
