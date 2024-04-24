package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "aaaLogout")
public class AaaLogoutRequest {
        @JacksonXmlProperty(isAttribute = true)
        private final String inCookie;

    public AaaLogoutRequest(String inCookie) {
        this.inCookie = inCookie;
    }

}


