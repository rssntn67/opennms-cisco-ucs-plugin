package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputeMbPowerStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public double consumedPower;
    @JacksonXmlProperty(isAttribute = true)
    public double consumedPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double consumedPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double consumedPowerMin;
    @JacksonXmlProperty(isAttribute = true)
    public double inputCurrent;
    @JacksonXmlProperty(isAttribute = true)
    public double inputCurrentAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double inputCurrentMax;
    @JacksonXmlProperty(isAttribute = true)
    public double inputCurrentMin;
    @JacksonXmlProperty(isAttribute = true)
    public double inputVoltage;
    @JacksonXmlProperty(isAttribute = true)
    public double inputVoltageAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double inputVoltageMax;
    @JacksonXmlProperty(isAttribute = true)
    public double inputVoltageMin;
}
