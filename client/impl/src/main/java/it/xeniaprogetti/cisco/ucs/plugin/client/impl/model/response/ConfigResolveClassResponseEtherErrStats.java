package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherErrStats;

import java.util.List;

public class ConfigResolveClassResponseEtherErrStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherErrStats> etherErrStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherErrStats{" +
                "etherErrStats=" + etherErrStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
