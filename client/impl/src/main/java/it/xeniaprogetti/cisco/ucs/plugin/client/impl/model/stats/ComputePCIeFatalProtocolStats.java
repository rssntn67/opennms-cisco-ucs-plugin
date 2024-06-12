package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputePCIeFatalProtocolStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public int dllpErrors2WeeksH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public int flowControlErrors2WeeksH;
}
