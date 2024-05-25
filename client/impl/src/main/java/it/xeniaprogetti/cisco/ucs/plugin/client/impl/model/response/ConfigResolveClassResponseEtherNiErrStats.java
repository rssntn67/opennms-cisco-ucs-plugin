package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherNiErrStats;

import java.util.List;

public class ConfigResolveClassResponseEtherNiErrStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherNiErrStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherNiErrStats{" +
                "etherNiErrStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
