package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortMcastStats;

import java.util.List;

public class ConfigResolveClassResponseAdaptorEthPortMcastStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<AdaptorEthPortMcastStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseAdaptorEthPortMcastStats {" +
                "adaptorEthPortMcastStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
