package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentFanModuleStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int FanModuleI2CErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int FanModuleI2CErrorsAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int FanModuleI2CErrorsMax;
    @JacksonXmlProperty(isAttribute = true)
    public int FanModuleI2CErrorsMin;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTemp;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMin;
}

