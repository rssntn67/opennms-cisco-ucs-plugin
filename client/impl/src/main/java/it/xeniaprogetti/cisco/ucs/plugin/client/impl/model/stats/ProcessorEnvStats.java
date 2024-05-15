package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ProcessorEnvStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrent;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentMax;
    @JacksonXmlProperty(isAttribute = true)
    public String inputCurrentMin;
    @JacksonXmlProperty(isAttribute = true)
    public double temperature;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureMax;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureMin;
}

