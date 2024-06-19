package it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CustomXmlMapper extends XmlMapper {
    public CustomXmlMapper() {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
