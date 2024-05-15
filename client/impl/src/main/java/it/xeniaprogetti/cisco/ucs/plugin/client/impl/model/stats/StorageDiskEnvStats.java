package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StorageDiskEnvStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public double temperature;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureMax;
    @JacksonXmlProperty(isAttribute = true)
    public double temperatureMin;
    @JacksonXmlProperty(isAttribute = true)
    public int wearPercentage;
    @JacksonXmlProperty(isAttribute = true)
    public int wearPercentageAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int wearPercentageMax;
    @JacksonXmlProperty(isAttribute = true)
    public int wearPercentageMin;
}

