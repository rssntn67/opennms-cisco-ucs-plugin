package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EquipmentRackEnclosure {
    @JacksonXmlProperty(isAttribute = true)
    public String assetTag;
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
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
    public Object partNumber;
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
}

