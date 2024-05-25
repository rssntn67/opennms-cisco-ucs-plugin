package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.MemoryUnitEnvStats;

import java.util.List;

public class ConfigResolveClassResponseMemoryUnitEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<MemoryUnitEnvStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseMemoryUnitEnvStats{" +
                "memoryUnitEnvStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
