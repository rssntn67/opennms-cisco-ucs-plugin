package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;

public class NetworkElement extends Dn {
    @JacksonXmlProperty(isAttribute = true)
    public String adminEvacState;
    @JacksonXmlProperty(isAttribute = true)
    public String adminInbandIfState;
    @JacksonXmlProperty(isAttribute = true)
    public int diffMemory;
    @JacksonXmlProperty(isAttribute = true)
    public int expectedMemory;
    @JacksonXmlProperty(isAttribute = true)
    public double fltAggr;
    @JacksonXmlProperty(isAttribute = true)
    public String forceEvac;
    @JacksonXmlProperty(isAttribute = true)
    public String id;
    @JacksonXmlProperty(isAttribute = true)
    public String inbandIfGw;
    @JacksonXmlProperty(isAttribute = true)
    public String inbandIfIp;
    @JacksonXmlProperty(isAttribute = true)
    public String inbandIfMask;
    @JacksonXmlProperty(isAttribute = true)
    public int inbandIfVnet;
    @JacksonXmlProperty(isAttribute = true)
    public String inventoryStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int minActiveFan;
    @JacksonXmlProperty(isAttribute = true)
    public String model;
    @JacksonXmlProperty(isAttribute = true)
    public String oobIfGw;
    @JacksonXmlProperty(isAttribute = true)
    public String oobIfIp;
    @JacksonXmlProperty(isAttribute = true)
    public String oobIfMac;
    @JacksonXmlProperty(isAttribute = true)
    public String oobIfMask;
    @JacksonXmlProperty(isAttribute = true)
    public String operEvacState;
    @JacksonXmlProperty(isAttribute = true)
    public String operability;
    @JacksonXmlProperty(isAttribute = true)
    public int revision;
    @JacksonXmlProperty(isAttribute = true)
    public String serial;
    @JacksonXmlProperty(isAttribute = true)
    public String shutdownFanRemoveal;
    @JacksonXmlProperty(isAttribute = true)
    public String thermal;
    @JacksonXmlProperty(isAttribute = true)
    public int totalMemory;
    @JacksonXmlProperty(isAttribute = true)
    public String vendor;

    @Override
    public String toString() {
        return "NetworkElement{" +
                "adminEvacState='" + adminEvacState + '\'' +
                ", adminInbandIfState='" + adminInbandIfState + '\'' +
                ", diffMemory=" + diffMemory +
                ", dn='" + dn + '\'' +
                ", expectedMemory=" + expectedMemory +
                ", fltAggr=" + fltAggr +
                ", forceEvac='" + forceEvac + '\'' +
                ", id='" + id + '\'' +
                ", inbandIfGw='" + inbandIfGw + '\'' +
                ", inbandIfIp='" + inbandIfIp + '\'' +
                ", inbandIfMask='" + inbandIfMask + '\'' +
                ", inbandIfVnet=" + inbandIfVnet +
                ", inventoryStatus='" + inventoryStatus + '\'' +
                ", minActiveFan=" + minActiveFan +
                ", model='" + model + '\'' +
                ", oobIfGw='" + oobIfGw + '\'' +
                ", oobIfIp='" + oobIfIp + '\'' +
                ", oobIfMac='" + oobIfMac + '\'' +
                ", oobIfMask='" + oobIfMask + '\'' +
                ", operEvacState='" + operEvacState + '\'' +
                ", operability='" + operability + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", shutdownFanRemoveal='" + shutdownFanRemoveal + '\'' +
                ", thermal='" + thermal + '\'' +
                ", totalMemory=" + totalMemory +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}

