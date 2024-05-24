package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;

import java.util.List;

public class ConfigResolveClassResponseSwCardEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<SwCardEnvStats> swCardEnvStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseSwEnvStats{" +
                "swCardEnvStats=" + swCardEnvStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
