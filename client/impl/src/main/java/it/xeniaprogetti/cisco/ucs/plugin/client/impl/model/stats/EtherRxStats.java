package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EtherRxStats extends Stats {
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
    public long jumboPackets;
    @JacksonXmlProperty(isAttribute = true)
    public long jumboPacketsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long jumboPacketsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long jumboPacketsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long jumboPacketsDeltaMin;
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
    public long totalBytes;
    @JacksonXmlProperty(isAttribute = true)
    public long totalBytesDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long totalBytesDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long totalBytesDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long totalBytesDeltaMin;
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

