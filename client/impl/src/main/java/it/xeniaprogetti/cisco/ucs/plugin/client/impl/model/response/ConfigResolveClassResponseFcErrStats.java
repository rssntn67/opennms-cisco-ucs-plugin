package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.FcErrStats;

import java.util.List;

public class ConfigResolveClassResponseFcErrStats extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<FcErrStats> fcErrStats;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseFcErrStats{" +
                "fcErrStats=" + fcErrStats +
                ", classId='" + classId + '\'' +
                '}';
    }
}
