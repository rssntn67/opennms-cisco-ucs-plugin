package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputeMbPowerStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public double consumedPower;
    @JacksonXmlProperty(isAttribute = true)
    public String consumedPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String consumedPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public String consumedPowerMin;
    @JacksonXmlProperty(isAttribute = true)
    public double inputCurrent;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentMax;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentMin;
    @JacksonXmlProperty(isAttribute = true)
    public double inputVoltage;
    @JacksonXmlProperty(isAttribute = true)
    public String inputVoltageAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String inputVoltageMax;
    @JacksonXmlProperty(isAttribute = true)
    public String inputVoltageMin;
}
