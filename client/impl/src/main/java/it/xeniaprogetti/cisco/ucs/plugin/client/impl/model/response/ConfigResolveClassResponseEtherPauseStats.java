package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherPauseStats;

import java.util.List;

public class ConfigResolveClassResponseEtherPauseStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherPauseStats> etherPauseStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherPauseStats{" +
                "etherPauseStats=" + etherPauseStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
