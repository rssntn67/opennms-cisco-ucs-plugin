package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

public class EquipmentFex extends UcsElement {
    @JacksonXmlProperty(isAttribute = true)
    public String adminPowerState;
    @JacksonXmlProperty(isAttribute = true)
    public String adminState;
    @JacksonXmlProperty(isAttribute = true)
    public String configState;
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
    @JacksonXmlProperty(isAttribute = true)
    public int fltAggr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmPrev;
    @JacksonXmlProperty(isAttribute = true)
    public int fsmProgr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvErrCode;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvErrDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmRmtInvRslt;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmStageDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmStamp;
    @JacksonXmlProperty(isAttribute = true)
    public String fsmStatus;
    @JacksonXmlProperty(isAttribute = true)
    public int fsmTry;
    @JacksonXmlProperty(isAttribute = true)
    public int id;
    @JacksonXmlProperty(isAttribute = true)
    public int licGP;
    @JacksonXmlProperty(isAttribute = true)
    public String licState;
    @JacksonXmlProperty(isAttribute = true)
    public String model;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifier;
    @JacksonXmlProperty(isAttribute = true)
    public String operQualifierReason;
    @JacksonXmlProperty(isAttribute = true)
    public String operState;
    @JacksonXmlProperty(isAttribute = true)
    public String operability;
    @JacksonXmlProperty(isAttribute = true)
    public String power;
    @JacksonXmlProperty(isAttribute = true)
    public String presence;
    @JacksonXmlProperty(isAttribute = true)
    public int revision;
    @JacksonXmlProperty(isAttribute = true)
    public String serial;
    @JacksonXmlProperty(isAttribute = true)
    public String switchId;
    @JacksonXmlProperty(isAttribute = true)
    public String thermal;
    @JacksonXmlProperty(isAttribute = true)
    public String usrLbl;
    @JacksonXmlProperty(isAttribute = true)
    public String vendor;
    @JacksonXmlProperty(isAttribute = true)
    public String voltage;
}


