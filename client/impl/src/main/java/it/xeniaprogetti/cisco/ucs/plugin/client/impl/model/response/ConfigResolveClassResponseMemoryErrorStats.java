package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.MemoryErrorStats;

import java.util.List;

public class ConfigResolveClassResponseMemoryErrorStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<MemoryErrorStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseMemoryErrorStats{" +
                "memoryErrorStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
