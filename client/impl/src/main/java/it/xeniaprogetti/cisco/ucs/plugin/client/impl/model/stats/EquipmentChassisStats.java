package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentChassisStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int ChassisI2CErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int ChassisI2CErrorsAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int ChassisI2CErrorsMax;
    @JacksonXmlProperty(isAttribute = true)
    public int ChassisI2CErrorsMin;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPower;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerMin;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPower;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerMin;
}

