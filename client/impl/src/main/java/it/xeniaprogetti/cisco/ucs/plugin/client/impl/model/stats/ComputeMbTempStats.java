package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputeMbTempStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenIo;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenIoAvg;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenIoMax;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenIoMin;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenRear;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenRearAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearL;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearLAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearLMax;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearLMin;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenRearMax;
    @JacksonXmlProperty(isAttribute = true)
    public double fmTempSenRearMin;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearR;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearRAvg;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearRMax;
    @JacksonXmlProperty(isAttribute = true)
    public String fmTempSenRearRMin;
}

