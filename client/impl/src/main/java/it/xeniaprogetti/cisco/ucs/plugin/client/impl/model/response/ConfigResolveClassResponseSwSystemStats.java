package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwSystemStats;

import java.util.List;

public class ConfigResolveClassResponseSwSystemStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<SwSystemStats> swSystemStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseSwSystemStats{" +
                "swSystemStats=" + swSystemStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}