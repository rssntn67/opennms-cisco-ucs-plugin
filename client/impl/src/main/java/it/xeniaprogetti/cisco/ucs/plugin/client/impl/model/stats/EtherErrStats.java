package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EtherErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long align;
    @JacksonXmlProperty(isAttribute = true)
    public long alignDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long alignDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long alignDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long alignDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long deferredTx;
    @JacksonXmlProperty(isAttribute = true)
    public long deferredTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long deferredTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long deferredTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long deferredTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long fcs;
    @JacksonXmlProperty(isAttribute = true)
    public long fcsDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long fcsDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long fcsDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long fcsDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacRx;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacTx;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long intMacTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long outDiscard;
    @JacksonXmlProperty(isAttribute = true)
    public long outDiscardDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long outDiscardDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long outDiscardDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long outDiscardDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long rcv;
    @JacksonXmlProperty(isAttribute = true)
    public long rcvDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long rcvDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long rcvDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long rcvDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long underSize;
    @JacksonXmlProperty(isAttribute = true)
    public long underSizeDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long underSizeDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long underSizeDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long underSizeDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long xmit;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long xmitDeltaMin;
}
