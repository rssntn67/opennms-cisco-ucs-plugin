package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ProcessorErrorStats;

import java.util.List;

public class ConfigResolveClassResponseProcessorErrorStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ProcessorErrorStats> processorErrorStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseProcessorErrorStats{" +
                "processorErrorStats=" + processorErrorStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
