package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ComputePCIeFatalCompletionStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long AbortErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public int AbortErrors2WeeksH;
    @JacksonXmlProperty(isAttribute = true)
    public long TimeoutErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public int TimeoutErrors2WeeksH;
    @JacksonXmlProperty(isAttribute = true)
    public long unexpectedErrors;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors15Min;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors15MinH;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1Day;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1DayH;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1Hour;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1HourH;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1Week;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors1WeekH;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors2Weeks;
    @JacksonXmlProperty(isAttribute = true)
    public int unexpectedErrors2WeeksH;
}

