package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogin")
public class AaaLoginRequest {
        @JacksonXmlProperty(isAttribute = true)
        private final String inName;
        @JacksonXmlProperty(isAttribute = true)
        private final String inPassword;

    public AaaLoginRequest(String inName, String inPassword) {
        this.inName = inName;
        this.inPassword = inPassword;
    }

}

