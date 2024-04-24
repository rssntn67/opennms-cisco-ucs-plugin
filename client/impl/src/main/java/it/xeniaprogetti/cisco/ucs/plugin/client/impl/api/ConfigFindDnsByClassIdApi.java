package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ConfigFindDnsByClassIdRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ConfigFindDnsByClassIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigFindDnsByClassIdApi {

    public enum Item {
        equipmentItem,
        computeItem
    }
    private final Logger LOG = LoggerFactory.getLogger(ConfigFindDnsByClassIdApi.class);
    private final ApiClient client;
    private final XmlMapper mapper = new XmlMapper();

    public ConfigFindDnsByClassIdApi(ApiClient client) {
        this.client = Objects.requireNonNull(client);
    }

    public List<String> getDnByClassId(String cookie, Item item) throws ApiException {
        try {
            ConfigFindDnsByClassIdResponse response =
                mapper.readValue(
                        client.doPost(
                                mapper.writeValueAsString(
                                        new ConfigFindDnsByClassIdRequest(item.name(), cookie))),
                        ConfigFindDnsByClassIdResponse.class);
            if (response.errorCode > 0) {
                LOG.error("getDnByClassId failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "getDnByClassId: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.outDns.stream().map(s -> s.value).collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            LOG.error("getDnByClassId: {}", e.getMessage(), e);
            throw new ApiException("getDnByClassId: " +e.getMessage(),e);
        }
    }

}
