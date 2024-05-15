package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SwCardEnvStats extends Stats {
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet1;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet1Avg;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet1Max;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet1Min;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet2;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet2Avg;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet2Max;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet2Min;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet3;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet3Avg;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet3Max;
    @JacksonXmlProperty(isAttribute = true)
    public String SlotOutlet3Min;
}

