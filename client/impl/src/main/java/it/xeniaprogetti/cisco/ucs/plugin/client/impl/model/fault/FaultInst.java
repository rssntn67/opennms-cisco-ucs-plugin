package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

import java.util.Date;

public class FaultInst extends UcsElement {

    @JacksonXmlProperty(isAttribute = true)
    public String ack;
    @JacksonXmlProperty(isAttribute = true)
    public String cause;
    @JacksonXmlProperty(isAttribute = true)
    public String changeSet;
    @JacksonXmlProperty(isAttribute = true)
    public String code;
    @JacksonXmlProperty(isAttribute = true)
    public Date created;
    @JacksonXmlProperty(isAttribute = true)
    public String descr;
    @JacksonXmlProperty(isAttribute = true)
    public String highestSeverity;
    @JacksonXmlProperty(isAttribute = true)
    public long id;
    @JacksonXmlProperty(isAttribute = true)
    public Date lastTransition;
    @JacksonXmlProperty(isAttribute = true)
    public String lc;
    @JacksonXmlProperty(isAttribute = true)
    public int occur;
    @JacksonXmlProperty(isAttribute = true)
    public String origSeverity;
    @JacksonXmlProperty(isAttribute = true)
    public String prevSeverity;
    @JacksonXmlProperty(isAttribute = true)
    public String rule;
    @JacksonXmlProperty(isAttribute = true)
    public String severity;
    @JacksonXmlProperty(isAttribute = true)
    public String tags;
    @JacksonXmlProperty(isAttribute = true)
    public String type;

    @Override
    public String toString() {
        return "FaultInst{" +
                "ack='" + ack + '\'' +
                ", cause='" + cause + '\'' +
                ", changeSet='" + changeSet + '\'' +
                ", code='" + code + '\'' +
                ", created=" + created +
                ", descr='" + descr + '\'' +
                ", highestSeverity='" + highestSeverity + '\'' +
                ", id=" + id +
                ", lastTransition=" + lastTransition +
                ", lc='" + lc + '\'' +
                ", occur=" + occur +
                ", origSeverity='" + origSeverity + '\'' +
                ", prevSeverity='" + prevSeverity + '\'' +
                ", rule='" + rule + '\'' +
                ", severity='" + severity + '\'' +
                ", tags='" + tags + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
