package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.StorageSsdHealthStats;

import java.util.List;

public class ConfigResolveClassResponseStorageSsdHealthStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<StorageSsdHealthStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseStorageSsdHealthStats{" +
                "storageSsdHealthStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
