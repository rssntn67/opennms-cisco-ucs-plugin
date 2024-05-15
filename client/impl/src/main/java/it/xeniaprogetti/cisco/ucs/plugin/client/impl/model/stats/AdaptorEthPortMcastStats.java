package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdaptorEthPortMcastStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long broadcastPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long broadcastPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long broadcastPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long broadcastPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long broadcastPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long multicastPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long multicastPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long multicastPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long multicastPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long multicastPacketsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public String trafficDirection;
    @JacksonXmlProperty(isAttribute = true)
    public long unicastPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long unicastPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long unicastPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long unicastPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long unicastPacketsDeltaMin;
}
