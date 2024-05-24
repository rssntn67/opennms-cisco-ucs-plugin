package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault.FaultInst;

import java.util.List;

public class ConfigResolveClassResponseFaultInst extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<FaultInst> faultInsts;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseFaultInstList{" +
                "faultInsts=" + faultInsts +
                ", classId='" + classId + '\'' +
                '}';
    }
}
