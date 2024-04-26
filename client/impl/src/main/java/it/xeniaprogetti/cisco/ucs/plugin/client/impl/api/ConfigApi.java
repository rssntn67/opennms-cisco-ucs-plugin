package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.UcsElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigFindDnsByClassIdResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigApi {

    public enum ClassItem {
        equipmentItem,
        computeItem,
        networkItem
    }

    public enum ClassId {
        equipmentChassis,
        equipmentFex,
        equipmentRackEnclosure,
        networkElement,
        computeBlade,
        computeRackUnit
    }
    private final Logger LOG = LoggerFactory.getLogger(ConfigApi.class);
    private final ApiClient client;
    private final XmlMapper mapper = new XmlMapper();

    public ConfigApi(ApiClient client) {
        this.client = Objects.requireNonNull(client);
    }

    public List<String> getDnByClassId(String cookie, ClassItem item) throws ApiException {
        try {
            ConfigFindDnsByClassIdResponse response =
                mapper.readValue(
                        client.doPost(
                            UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(item.name(), cookie)),
                            ConfigFindDnsByClassIdResponse.class
                );
            if (response.errorCode > 0) {
                LOG.error("getDnByClassId failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "getDnByClassId: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.dns.stream().map(s -> s.value).collect(Collectors.toList());
        } catch (JsonProcessingException e) {
            LOG.error("getDnByClassId: {}", e.getMessage(), e);
            throw new ApiException("getDnByClassId: " +e.getMessage(),e);
        }
    }

    /*
    public <T extends UcsElement> T getUcsElementByDn(String cookie, String dn, Class<T> clazz) throws ApiException {
        try {
            ConfigResolveDnResponse<T> response = mapper.readValue(
                    client.doPost(
                            UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false)),
                    mapper.getTypeFactory().constructParametricType(ConfigResolveDnResponse.class,clazz));
            if (response.errorCode > 0) {
                LOG.error("getDnBy failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "getDnBy: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.outconfig.ucsElement;
        } catch (JsonProcessingException e) {
            LOG.error("getByDn: {}", e.getMessage(), e);
            throw new ApiException("getByDn: " +e.getMessage(),e);
        }
    }*/

    public <T extends UcsElement> List<T> getUcsElementsByClassId(String cookie, Class<T> clazz) throws ApiException {
        ClassId classId;
        switch (clazz.getSimpleName()) {
            case "ComputeBlade":
                classId = ClassId.computeBlade;
                break;

            case "ComputeRackUnit":
                classId = ClassId.computeRackUnit;
                break;

            case "EquipmentChassis":
                classId = ClassId.equipmentChassis;
                break;

            case "EquipmentFex":
                classId = ClassId.equipmentFex;
                break;

            case "EquipmentRackEnclosure":
                classId = ClassId.equipmentRackEnclosure;
                break;

            case "NetworkElement":
                classId = ClassId.networkElement;
                break;

            default:
                LOG.error("getByClassId: cannot found ClassId for {}", clazz.getSimpleName());
                throw new ApiException("getByClassId: Cannot find classId for " + clazz.getSimpleName(), new RuntimeException("Error parsing Class"));
        }
        try {
            ConfigResolveClassResponse<T> response = mapper.readValue(
                    client.doPost(
                            UcsXmlApiRequest.getConfigResolveClassRequest(cookie,classId.name())),
                    mapper.getTypeFactory().constructParametricType(ConfigResolveClassResponse.class,clazz));
            if (response.errorCode > 0) {
                LOG.error("getByClassId failed: with error code: {}, {}", response.errorCode, response);
                throw new ApiException(
                        "getByClassId: server responded with error: " + response.errorCode
                        ,new RuntimeException("login error code: " + response.errorCode)
                        , response.errorCode
                        , response.toString());
            }
            return response.ucsElements;
        } catch (JsonProcessingException e) {
            LOG.error("getByDn: {}", e.getMessage(), e);
            throw new ApiException("getByDn: " +e.getMessage(),e);
        }
    }
}
