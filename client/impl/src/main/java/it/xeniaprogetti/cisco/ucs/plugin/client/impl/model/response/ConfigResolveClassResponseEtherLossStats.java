package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherLossStats;

import java.util.List;

public class ConfigResolveClassResponseEtherLossStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherLossStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherLossStats{" +
                "etherLossStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
