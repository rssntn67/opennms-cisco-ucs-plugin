package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

public class EquipmentRackEnclosure extends UcsElement {
    @JacksonXmlProperty(isAttribute = true)
    public String assetTag;
    @JacksonXmlProperty(isAttribute = true)
    public int fltAggr;
    @JacksonXmlProperty(isAttribute = true)
    public int id;
    @JacksonXmlProperty(isAttribute = true)
    public String mfgTime;
    @JacksonXmlProperty(isAttribute = true)
    public String model;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifierReason;
    @JacksonXmlProperty(isAttribute = true)
    public String operability;
    @JacksonXmlProperty(isAttribute = true)
    public String partNumber;
    @JacksonXmlProperty(isAttribute = true)
    public String presence;
    @JacksonXmlProperty(isAttribute = true)
    public int revision;
    @JacksonXmlProperty(isAttribute = true)
    public String serial;
    @JacksonXmlProperty(isAttribute = true)
    public String vendor;
    @JacksonXmlProperty(isAttribute = true)
    public int vid;

    @Override
    public String toString() {
        return "EquipmentRackEnclosure{" +
                "assetTag='" + assetTag + '\'' +
                ", dn='" + dn + '\'' +
                ", fltAggr=" + fltAggr +
                ", id=" + id +
                ", mfgTime='" + mfgTime + '\'' +
                ", model='" + model + '\'' +
                ", operQualifierReason='" + operQualifierReason + '\'' +
                ", operability='" + operability + '\'' +
                ", partNumber=" + partNumber +
                ", presence='" + presence + '\'' +
                ", revision=" + revision +
                ", serial='" + serial + '\'' +
                ", vendor='" + vendor + '\'' +
                ", vid=" + vid +
                '}';
    }
}

