package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EtherNiErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int crc;
    @JacksonXmlProperty(isAttribute = true)
    public int crcDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int crcDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int crcDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int crcDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int frameTx;
    @JacksonXmlProperty(isAttribute = true)
    public int frameTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int frameTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int frameTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int frameTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int inRange;
    @JacksonXmlProperty(isAttribute = true)
    public int inRangeDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int inRangeDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int inRangeDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int inRangeDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLong;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShort;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortDeltaMin;
}

