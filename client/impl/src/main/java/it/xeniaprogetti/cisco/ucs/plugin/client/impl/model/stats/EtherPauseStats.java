package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EtherPauseStats extends Stats{
    @JacksonXmlProperty(isAttribute = true)
    public long recvPause;
    @JacksonXmlProperty(isAttribute = true)
    public long recvPauseDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long recvPauseDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long recvPauseDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long recvPauseDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long resets;
    @JacksonXmlProperty(isAttribute = true)
    public long resetsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long resetsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long resetsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long resetsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitPause;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitPauseDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitPauseDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitPauseDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitPauseDeltaMin;
}

