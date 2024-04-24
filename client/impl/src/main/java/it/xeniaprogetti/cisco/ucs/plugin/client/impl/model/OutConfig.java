package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "outConfig")
public class OutConfig {
    @JacksonXmlCData
    public EquipmentChassis equipmentChassis;

    @JacksonXmlCData
    public ComputeBlade computeBlade;

}
