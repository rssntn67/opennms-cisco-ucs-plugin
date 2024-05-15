package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentPsuInputStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public double current;
    @JacksonXmlProperty(isAttribute = true)
    public double currentAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double currentMax;
    @JacksonXmlProperty(isAttribute = true)
    public double currentMin;
    @JacksonXmlProperty(isAttribute = true)
    public String inputStatus;
    @JacksonXmlProperty(isAttribute = true)
    public double power;
    @JacksonXmlProperty(isAttribute = true)
    public double powerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double powerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double powerMin;
    @JacksonXmlProperty(isAttribute = true)
    public double voltage;
    @JacksonXmlProperty(isAttribute = true)
    public double voltageAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double voltageMax;
    @JacksonXmlProperty(isAttribute = true)
    public double voltageMin;
}

