package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FcStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRx;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTx;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int bytesTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsRx;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsTx;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int packetsTxDeltaMin;
}

