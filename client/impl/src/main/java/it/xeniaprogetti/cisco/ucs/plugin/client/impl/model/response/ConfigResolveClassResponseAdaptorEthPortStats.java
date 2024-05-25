package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortStats;

import java.util.List;

public class ConfigResolveClassResponseAdaptorEthPortStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<AdaptorEthPortStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseAdaptorEthPortStats{" +
                "adaptorEthPortStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
