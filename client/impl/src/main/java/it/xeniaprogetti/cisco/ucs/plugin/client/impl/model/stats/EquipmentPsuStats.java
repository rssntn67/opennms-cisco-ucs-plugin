package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentPsuStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int PsuI2CErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int PsuI2CErrorsAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int PsuI2CErrorsMax;
    @JacksonXmlProperty(isAttribute = true)
    public int PsuI2CErrorsMin;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTemp;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMax;
    @JacksonXmlProperty(isAttribute = true)
    public double ambientTempMin;
    @JacksonXmlProperty(isAttribute = true)
    public double input210v;
    @JacksonXmlProperty(isAttribute = true)
    public double input210vAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double input210vMax;
    @JacksonXmlProperty(isAttribute = true)
    public double input210vMin;
    @JacksonXmlProperty(isAttribute = true)
    public String inputPower;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double inputPowerMin;
    @JacksonXmlProperty(isAttribute = true)
    public double output12v;
    @JacksonXmlProperty(isAttribute = true)
    public double output12vAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double output12vMax;
    @JacksonXmlProperty(isAttribute = true)
    public double output12vMin;
    @JacksonXmlProperty(isAttribute = true)
    public double output3v3;
    @JacksonXmlProperty(isAttribute = true)
    public double output3v3Avg;
    @JacksonXmlProperty(isAttribute = true)
    public double output3v3Max;
    @JacksonXmlProperty(isAttribute = true)
    public double output3v3Min;
    @JacksonXmlProperty(isAttribute = true)
    public double outputCurrent;
    @JacksonXmlProperty(isAttribute = true)
    public double outputCurrentAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double outputCurrentMax;
    @JacksonXmlProperty(isAttribute = true)
    public double outputCurrentMin;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPower;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerMax;
    @JacksonXmlProperty(isAttribute = true)
    public double outputPowerMin;
    @JacksonXmlProperty(isAttribute = true)
    public String psuTemp1;
    @JacksonXmlProperty(isAttribute = true)
    public String psuTemp2;
}

