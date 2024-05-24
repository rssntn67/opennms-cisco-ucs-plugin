package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortErrStats;

import java.util.List;

public class ConfigResolveClassResponseAdaptorEthPortErrStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<AdaptorEthPortErrStats> adaptorEthPortErrStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseAdaptorEthPortErrStats{" +
                "adaptorEthPortErrStats=" + adaptorEthPortErrStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
