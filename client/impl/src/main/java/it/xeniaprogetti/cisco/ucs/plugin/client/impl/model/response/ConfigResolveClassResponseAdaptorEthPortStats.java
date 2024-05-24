package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortStats;

import java.util.List;

public class ConfigResolveClassResponseAdaptorEthPortStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<AdaptorEthPortStats> adaptorEthPortStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseAdaptorEthPortStats{" +
                "adaptorEthPortStats=" + adaptorEthPortStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
