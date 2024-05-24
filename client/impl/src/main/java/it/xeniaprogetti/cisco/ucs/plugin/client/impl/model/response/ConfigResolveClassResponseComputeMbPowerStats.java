package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbPowerStats;

import java.util.List;

public class ConfigResolveClassResponseComputeMbPowerStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<ComputeMbPowerStats> computeMbPowerStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseComputeMbPowerStats{" +
                "computeMbPowerStats=" + computeMbPowerStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
