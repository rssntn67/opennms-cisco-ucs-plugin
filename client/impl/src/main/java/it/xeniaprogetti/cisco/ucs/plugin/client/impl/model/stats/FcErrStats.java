package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FcErrStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public int crcRx;
    @JacksonXmlProperty(isAttribute = true)
    public int crcRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int crcRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int crcRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int crcRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int discardRx;
    @JacksonXmlProperty(isAttribute = true)
    public int discardRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int discardRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int discardRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int discardRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int discardTx;
    @JacksonXmlProperty(isAttribute = true)
    public int discardTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int discardTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int discardTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int discardTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int linkFailures;
    @JacksonXmlProperty(isAttribute = true)
    public int linkFailuresDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int linkFailuresDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int linkFailuresDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int linkFailuresDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int rx;
    @JacksonXmlProperty(isAttribute = true)
    public int rxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int rxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int rxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int rxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int signalLosses;
    @JacksonXmlProperty(isAttribute = true)
    public int signalLossesDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int signalLossesDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int signalLossesDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int signalLossesDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int syncLosses;
    @JacksonXmlProperty(isAttribute = true)
    public int syncLossesDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int syncLossesDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int syncLossesDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int syncLossesDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongRx;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int tooLongRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortRx;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public int tooShortRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public int tx;
    public int txDelta;
    public int txDeltaAvg;
    public int txDeltaMax;
    public int txDeltaMin;
}
