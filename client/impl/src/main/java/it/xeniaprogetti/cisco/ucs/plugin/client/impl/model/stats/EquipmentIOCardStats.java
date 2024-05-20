package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentIOCardStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int IomI2CErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int IomI2CErrorsAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int IomI2CErrorsMax;
    @JacksonXmlProperty(isAttribute = true)
    public int IomI2CErrorsMin;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTemp;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMin;
    @JacksonXmlProperty(isAttribute = true)
    public String dimmTemp;
    @JacksonXmlProperty(isAttribute = true)
    public double dimmTempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double dimmTempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double dimmTempMin;
    @JacksonXmlProperty(isAttribute = true)
    public String procTemp;
    @JacksonXmlProperty(isAttribute = true)
    public double procTempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double procTempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double procTempMin;
    @JacksonXmlProperty(isAttribute = true)
    public double temp;
    @JacksonXmlProperty(isAttribute = true)
    public double tempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double tempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double tempMin;
}

