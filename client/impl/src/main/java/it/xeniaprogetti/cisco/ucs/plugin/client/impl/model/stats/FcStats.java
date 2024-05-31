package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FcStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRx;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTx;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long bytesTxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsRx;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsRxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsRxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsRxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsRxDeltaMin;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsTx;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsTxDelta;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsTxDeltaAvg;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsTxDeltaMax;
    @JacksonXmlProperty(isAttribute = true)
    public long packetsTxDeltaMin;

    @Override
    public String toString() {
        return "FcStats{" +
                "bytesRx=" + bytesRx +
                ", bytesRxDelta=" + bytesRxDelta +
                ", bytesRxDeltaAvg=" + bytesRxDeltaAvg +
                ", bytesRxDeltaMax=" + bytesRxDeltaMax +
                ", bytesRxDeltaMin=" + bytesRxDeltaMin +
                ", bytesTx=" + bytesTx +
                ", bytesTxDelta=" + bytesTxDelta +
                ", bytesTxDeltaAvg=" + bytesTxDeltaAvg +
                ", bytesTxDeltaMax=" + bytesTxDeltaMax +
                ", bytesTxDeltaMin=" + bytesTxDeltaMin +
                ", packetsRx=" + packetsRx +
                ", packetsRxDelta=" + packetsRxDelta +
                ", packetsRxDeltaAvg=" + packetsRxDeltaAvg +
                ", packetsRxDeltaMax=" + packetsRxDeltaMax +
                ", packetsRxDeltaMin=" + packetsRxDeltaMin +
                ", packetsTx=" + packetsTx +
                ", packetsTxDelta=" + packetsTxDelta +
                ", packetsTxDeltaAvg=" + packetsTxDeltaAvg +
                ", packetsTxDeltaMax=" + packetsTxDeltaMax +
                ", packetsTxDeltaMin=" + packetsTxDeltaMin +
                ", intervals=" + intervals +
                ", suspect='" + suspect + '\'' +
                ", thresholded='" + thresholded + '\'' +
                ", timeCollected=" + timeCollected +
                ", update=" + update +
                ", dn='" + dn + '\'' +
                '}';
    }
}

