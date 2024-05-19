package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SwSystemStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public String CorrectableParityError;
    @JacksonXmlProperty(isAttribute = true)
    public String CorrectableParityErrorAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String CorrectableParityErrorMax;
    @JacksonXmlProperty(isAttribute = true)
    public String CorrectableParityErrorMin;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemFree;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemFreeAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemFreeMax;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemFreeMin;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemTotal;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemTotalAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemTotalMax;
    @JacksonXmlProperty(isAttribute = true)
    public String kernelMemTotalMin;
    @JacksonXmlProperty(isAttribute = true)
    public double load;
    @JacksonXmlProperty(isAttribute = true)
    public double loadAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double loadMax;
    @JacksonXmlProperty(isAttribute = true)
    public double loadMin;
    @JacksonXmlProperty(isAttribute = true)
    public int memAvailable;
    @JacksonXmlProperty(isAttribute = true)
    public int memAvailableAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int memAvailableMax;
    @JacksonXmlProperty(isAttribute = true)
    public int memAvailableMin;
    @JacksonXmlProperty(isAttribute = true)
    public int memCached;
    @JacksonXmlProperty(isAttribute = true)
    public int memCachedAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int memCachedMax;
    @JacksonXmlProperty(isAttribute = true)
    public int memCachedMin;
}

