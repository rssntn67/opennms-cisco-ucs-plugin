package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigFindDnsByClassIdResponse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseNetworkElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigApi {

    private final Logger LOG = LoggerFactory.getLogger(ConfigApi.class);
    private final ApiClient client;
    private final String url;

    public ConfigApi(ApiClient client, String url) {
        this.client = Objects.requireNonNull(client);
        this.url = Objects.requireNonNull(url);
    }

    public List<String> getDnByClassId(String cookie, UcsEnums.NamingClassId item) throws ApiException {
        LOG.info("getDnByClassId: {}", item);
        return client.getUcsXmlApiResponse(
                            UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(cookie,item),
                            this.url,
                            ConfigFindDnsByClassIdResponse.class
                ).dns.stream().map(s -> s.value).collect(Collectors.toList());
    }

    public String getUcsEntityByDn(String cookie, String dn, boolean inHierarchical) throws ApiException {
        LOG.info("getUcsEntityByDn: {}", dn);
        return client.doPost(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,inHierarchical), url);
    }

    public ComputeBlade getUcsComputeBladeByResponse(String response) throws ApiException {
            return client.getUcsEntity(response,
                    ConfigResolveDnResponseComputeBlade.class)
                    .outconfig
                    .computeBlade;
    }

    public ComputeRackUnit getUcsComputeRackUnitByResponse(String response) throws ApiException {
        return client.getUcsEntity(response,
                ConfigResolveDnResponseComputeRackUnit.class)
                .outconfig
                .computeRackUnit;
    }

    public EquipmentChassis getUcsEquipmentChassisByResponse(String response) throws ApiException {
        return client.getUcsEntity(response,
                ConfigResolveDnResponseEquipmentChassis.class)
                .outconfig
                .equipmentChassis;
    }

    public EquipmentFex getUcsEquipmentFexByResponse(String response) throws ApiException {
        return client.getUcsEntity(response,
                ConfigResolveDnResponseEquipmentFex.class)
                .outconfig
                .equipmentFex;
    }

    public EquipmentRackEnclosure getUcsEquipmentRackEnclosureByResponse(String response) throws ApiException {
        return client.getUcsEntity(response,
                ConfigResolveDnResponseEquipmentRackEnclosure.class)
                .outconfig
                .equipmentRackEnclosure;
    }

    public NetworkElement getUcsNetworkElementByResponse(String response) throws ApiException {
        return client.getUcsXmlApiResponse(response, this.url,
                ConfigResolveDnResponseNetworkElement.class)
                .outconfig
                .networkElement;
    }

    public List<ComputeBlade> getUcsComputeBladeListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsComputeBladeListByClassId: {}", UcsEnums.NamingClassId.computeBlade);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.computeBlade),
                this.url,
                ConfigResolveClassResponseComputeBlade.class
        ).computeBlades;
    }

    public List<ComputeRackUnit> getUcsComputeRackUnitListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsComputeBladeByClassId: {}" , UcsEnums.NamingClassId.computeRackUnit);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.computeRackUnit),
                this.url,
                ConfigResolveClassResponseComputeRackUnit.class
        ).computeRackUnits;
    }

    public List<EquipmentChassis> getUcsEquipmentChassisListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentChassisListByClassId: {}", UcsEnums.NamingClassId.equipmentChassis);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.equipmentChassis),
                this.url,
                ConfigResolveClassResponseEquipmentChassis.class
        ).equipmentChasses;
    }

    public List<EquipmentFex> getUcsEquipmentFexListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentFexListByClassId: {}", UcsEnums.NamingClassId.equipmentFex);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.equipmentFex),
                this.url,
                ConfigResolveClassResponseEquipmentFex.class
        ).equipmentFexes;
    }

    public List<EquipmentRackEnclosure> getUcsEquipmentRackEnclosureListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentRackEnclosureListByClassId: {}", UcsEnums.NamingClassId.equipmentRackEnclosure);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.equipmentRackEnclosure),
                this.url,
                ConfigResolveClassResponseEquipmentRackEnclosure.class
        ).equipmentRackEnclosures;
    }

    public List<NetworkElement> getUcsNetworkElementListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsNetworkElementListByClassId: {}", UcsEnums.NamingClassId.networkElement);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.networkElement),
                this.url,
                ConfigResolveClassResponseNetworkElement.class
        ).networkElements;
    }
}