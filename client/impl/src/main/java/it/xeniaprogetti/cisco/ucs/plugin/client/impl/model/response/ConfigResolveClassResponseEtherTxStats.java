package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherTxStats;

import java.util.List;

public class ConfigResolveClassResponseEtherTxStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<EtherTxStats> etherTxStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseEtherTxStats{" +
                "etherTxStats=" + etherTxStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
