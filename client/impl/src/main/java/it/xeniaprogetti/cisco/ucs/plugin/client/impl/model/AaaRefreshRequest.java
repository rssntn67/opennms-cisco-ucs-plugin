package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaRefresh")
public class AaaRefreshRequest {
        @JacksonXmlProperty(isAttribute = true)
        private final String inName;
        @JacksonXmlProperty(isAttribute = true)
        private final String inPassword;
        @JacksonXmlProperty(isAttribute = true)
        private final String inCookie;

    public AaaRefreshRequest(String inName, String inPassword, String inCookie) {
        this.inName = inName;
        this.inPassword = inPassword;
        this.inCookie = inCookie;
    }

}


