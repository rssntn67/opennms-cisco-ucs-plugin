package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.FcStats;

import java.util.List;

public class ConfigResolveClassResponseFcStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<FcStats> stats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseFcStats{" +
                "fcStats=" + stats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
