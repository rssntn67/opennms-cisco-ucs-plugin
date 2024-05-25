package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;

import java.util.List;

public class ConfigResolveClassResponseSwEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<SwEnvStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseSwEnvStats{" +
                "swEnvStatsList=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
