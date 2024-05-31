package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdaptorEthPortErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long badCrcPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long badCrcPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long badCrcPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long badCrcPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long badCrcPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long badLengthPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long badLengthPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long badLengthPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long badLengthPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long badLengthPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long macDiscardedPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long macDiscardedPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long macDiscardedPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long macDiscardedPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long macDiscardedPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public String trafficDirection;
}

