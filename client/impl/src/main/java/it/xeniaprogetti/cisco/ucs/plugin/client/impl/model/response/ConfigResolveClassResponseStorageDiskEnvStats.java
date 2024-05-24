package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.StorageDiskEnvStats;

import java.util.List;

public class ConfigResolveClassResponseStorageDiskEnvStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<StorageDiskEnvStats> storageDiskEnvStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseStorageDiskEnvStats{" +
                "storageDiskEnvStats=" + storageDiskEnvStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
