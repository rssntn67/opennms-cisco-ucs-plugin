package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.StorageSsdHealthStats;

import java.util.List;

public class ConfigResolveClassResponseStorageSsdHealthEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<StorageSsdHealthStats> storageSsdHealthStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseStorageSsdHealthStats{" +
                "storageSsdHealthStats=" + storageSsdHealthStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
