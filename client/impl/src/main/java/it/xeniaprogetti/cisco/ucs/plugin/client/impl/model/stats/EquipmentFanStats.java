package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentFanStats {
    @JacksonXmlProperty(isAttribute = true)
    public int speed;
    @JacksonXmlProperty(isAttribute = true)
    public int speedAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int speedMax;
    @JacksonXmlProperty(isAttribute = true)
    public int speedMin;
}

