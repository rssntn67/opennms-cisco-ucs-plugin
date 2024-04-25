package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ConfigResolveDnRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ConfigResolveDnApi {

    private final Logger LOG = LoggerFactory.getLogger(ConfigResolveDnApi.class);
    private final ApiClient client;
    private final XmlMapper mapper = new XmlMapper();

    public ConfigResolveDnApi(ApiClient client) {
        this.client = Objects.requireNonNull(client);
    }

    public String getByDn(String cookie, String dn, boolean isHierarchical) throws ApiException {
        try {
           return
//                mapper.readValue(
                        client.doPost(
                                mapper.writeValueAsString(
                                        new ConfigResolveDnRequest(cookie,dn,isHierarchical)))
            //,
            //            String.class)
            ;
            /*
            if (response.errorCode > 0) {
                LOG.error("getDnByClassId failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "getDnByClassId: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }*/
        } catch (JsonProcessingException e) {
            LOG.error("getByDn: {}", e.getMessage(), e);
            throw new ApiException("getByDn: " +e.getMessage(),e);
        }
    }

}
