package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;

import java.util.List;

public class ConfigResolveClassResponseNetworkElement extends ConfigResolveClassResponse {
    @JacksonXmlElementWrapper(localName = "outConfigs")
    public List<NetworkElement> networkElements;

    @Override
    public String toString() {
        return "ConfigResolveClassResponseNetworkElementList{" +
                "networkElements=" + networkElements +
                ", classId='" + classId + '\'' +
                '}';
    }
}
