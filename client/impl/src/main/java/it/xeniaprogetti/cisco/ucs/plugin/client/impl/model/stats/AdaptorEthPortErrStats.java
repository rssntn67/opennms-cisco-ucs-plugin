package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdaptorEthPortErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int badCrcPackets;
    @JacksonXmlProperty(isAttribute = true)
    public int badCrcPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int badCrcPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int badCrcPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int badCrcPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int badLengthPackets;
    @JacksonXmlProperty(isAttribute = true)
    public int badLengthPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int badLengthPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int badLengthPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int badLengthPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int macDiscardedPackets;
    @JacksonXmlProperty(isAttribute = true)
    public int macDiscardedPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int macDiscardedPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int macDiscardedPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int macDiscardedPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public String trafficDirection;
}

