package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorVnicStats;

import java.util.List;

public class ConfigResolveClassResponseAdaptorVnicStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<AdaptorVnicStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseAdaptorVnicStats{" +
                "adaptorVnicStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
