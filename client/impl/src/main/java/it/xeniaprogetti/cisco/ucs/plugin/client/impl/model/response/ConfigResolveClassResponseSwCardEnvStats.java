package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwCardEnvStats;

import java.util.List;

public class ConfigResolveClassResponseSwCardEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<SwCardEnvStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseSwEnvStats{" +
                "swCardEnvStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
