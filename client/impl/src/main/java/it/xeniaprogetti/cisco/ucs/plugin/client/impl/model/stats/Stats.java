package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;

import java.util.Date;

public class Stats extends Dn  {
    @JacksonXmlProperty(isAttribute = true)
    public long intervals;
    @JacksonXmlProperty(isAttribute = true)
    public String suspect;
    public String thresholded;
    @JacksonXmlProperty(isAttribute = true)
    public Date timeCollected;
    @JacksonXmlProperty(isAttribute = true)
    public long update;

}
