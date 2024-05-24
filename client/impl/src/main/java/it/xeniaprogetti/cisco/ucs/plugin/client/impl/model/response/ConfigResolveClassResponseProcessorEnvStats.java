package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ProcessorEnvStats;

import java.util.List;

public class ConfigResolveClassResponseProcessorEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ProcessorEnvStats> processorEnvStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseProcessorEnvStats{" +
                "processorEnvStats=" + processorEnvStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
