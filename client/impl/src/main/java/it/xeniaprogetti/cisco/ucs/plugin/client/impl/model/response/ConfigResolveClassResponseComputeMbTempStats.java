package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbTempStats;

import java.util.List;

public class ConfigResolveClassResponseComputeMbTempStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputeMbTempStats> computeMbTempStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputeMbTempStats{" +
                "computeMbTempStats=" + computeMbTempStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
