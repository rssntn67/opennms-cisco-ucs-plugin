package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogin")
public class AaaLogin {
        @JacksonXmlProperty(isAttribute = true)
        private String inName;
        @JacksonXmlProperty(isAttribute = true)
        private String inPassword;

    public String getInName() {
        return inName;
    }

    public void setInName(String inName) {
        this.inName = inName;
    }

    public String getInPassword() {
        return inPassword;
    }

    public void setInPassword(String inPassword) {
        this.inPassword = inPassword;
    }
}


