package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "dn")
public class DistinguishedName {
    @JacksonXmlProperty(isAttribute = true)
    public String value;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dn{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
