package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputePCIeFatalProtocolStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public long dllpErrors2WeeksH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public long flowControlErrors2WeeksH;
}
