package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdaptorEthPortStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long goodPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long goodPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long goodPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long goodPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long goodPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long pausePackets;
    @JacksonXmlProperty(isAttribute = true)
    public long pausePacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long pausePacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long pausePacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long pausePacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long perPriorityPausePackets;
    @JacksonXmlProperty(isAttribute = true)
    public long perPriorityPausePacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long perPriorityPausePacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long perPriorityPausePacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long perPriorityPausePacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long pppPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long pppPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long pppPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long pppPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long pppPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long totalPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long totalPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long totalPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long totalPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long totalPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public String trafficDirection;
    @JacksonXmlProperty(isAttribute = true)
    public long vlanPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long vlanPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long vlanPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long vlanPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long vlanPacketsDeltaMin;
}

