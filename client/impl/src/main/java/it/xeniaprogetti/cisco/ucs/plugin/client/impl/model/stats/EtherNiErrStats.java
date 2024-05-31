package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EtherNiErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long crc;
    @JacksonXmlProperty(isAttribute = true)
    public long crcDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long crcDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long crcDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long crcDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long frameTx;
    @JacksonXmlProperty(isAttribute = true)
    public long frameTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long frameTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long frameTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long frameTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long inRange;
    @JacksonXmlProperty(isAttribute = true)
    public long inRangeDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long inRangeDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long inRangeDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long inRangeDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long tooLong;
    @JacksonXmlProperty(isAttribute = true)
    public long tooLongDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long tooLongDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long tooLongDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long tooLongDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long tooShort;
    @JacksonXmlProperty(isAttribute = true)
    public long tooShortDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long tooShortDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long tooShortDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long tooShortDeltaMin;
}

