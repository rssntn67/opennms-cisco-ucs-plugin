package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentNetworkElementFanStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public String airflowDirection;
    @JacksonXmlProperty(isAttribute = true)
    public int drivePercentage;
    @JacksonXmlProperty(isAttribute = true)
    public int drivePercentageAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int drivePercentageMax;
    @JacksonXmlProperty(isAttribute = true)
    public int drivePercentageMin;
    @JacksonXmlProperty(isAttribute = true)
    public int speed;
    @JacksonXmlProperty(isAttribute = true)
    public int speedAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int speedMax;
    @JacksonXmlProperty(isAttribute = true)
    public int speedMin;
}

