package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StorageSsdHealthStats extends Stats{
    @JacksonXmlProperty(isAttribute = true)
    public String id;
    @JacksonXmlProperty(isAttribute = true)
    public int percentageLifeLeft;
    @JacksonXmlProperty(isAttribute = true)
    public int percentageLifeLeftAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int percentageLifeLeftMax;
    @JacksonXmlProperty(isAttribute = true)
    public int percentageLifeLeftMin;
    @JacksonXmlProperty(isAttribute = true)
    public int powerCycleCount;
    @JacksonXmlProperty(isAttribute = true)
    public int powerCycleCountAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int powerCycleCountMax;
    @JacksonXmlProperty(isAttribute = true)
    public int powerCycleCountMin;
    @JacksonXmlProperty(isAttribute = true)
    public int powerOnHours;
    @JacksonXmlProperty(isAttribute = true)
    public int powerOnHoursAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int powerOnHoursMax;
    @JacksonXmlProperty(isAttribute = true)
    public int powerOnHoursMin;
    @JacksonXmlProperty(isAttribute = true)
    public int wearStatusInDays;
    @JacksonXmlProperty(isAttribute = true)
    public int wearStatusInDaysAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int wearStatusInDaysMax;
    @JacksonXmlProperty(isAttribute = true)
    public int wearStatusInDaysMin;
}

