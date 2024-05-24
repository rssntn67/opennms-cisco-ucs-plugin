package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherRxStats;

import java.util.List;

public class ConfigResolveClassResponseEtherRxStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherRxStats> etherRxStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherRxStats{" +
                "etherRxStats=" + etherRxStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
