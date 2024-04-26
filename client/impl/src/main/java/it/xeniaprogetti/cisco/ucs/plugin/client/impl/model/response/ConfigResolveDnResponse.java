package it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;

@JacksonXmlRootElement(localName = "configResolveDn")
public class ConfigResolveDnResponse<T extends UcsElement> {
    @JacksonXmlProperty(isAttribute = true)
    public String cookie;
    @JacksonXmlProperty(isAttribute = true)
    public String response;
    @JacksonXmlProperty(isAttribute = true)
    public int errorCode;
    @JacksonXmlProperty(isAttribute = true)
    public String errorDescr;
    @JacksonXmlProperty(isAttribute = true)
    public String invocationResult;
    @JacksonXmlProperty(isAttribute = true)
    public String dn;
    @JacksonXmlElementWrapper(localName = "outConfig")
    public  OutConfig outconfig;

    @Override
    public String toString() {
        return "ConfigResolveDnResponse{" +
                "cookie='" + cookie + '\'' +
                ", response='" + response + '\'' +
                ", errorCode=" + errorCode +
                ", errorDescr='" + errorDescr + '\'' +
                ", invocationResult='" + invocationResult + '\'' +
                ", dn='" + dn + '\'' +
                ", ucsElement=" + outconfig.ucsElement +
                '}';
    }

    public class OutConfig {
        public T ucsElement;
    }
}
