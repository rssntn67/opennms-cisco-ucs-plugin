package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConfigApi {

    public enum ClassItem {
        equipmentItem,
        computeItem
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

    public ConfigApi(ApiClient client) {
        this.client = Objects.requireNonNull(client);
    }

    public List<String> getDnByClassId(String cookie, ClassItem item) throws ApiException {
        LOG.info("getDnByClassId: {}", item);
        return client.getUcsXmlApiResponse(
                            UcsXmlApiRequest.getConfigFindDnsByClassIdRequest(cookie,item.name()),
                            ConfigFindDnsByClassIdResponse.class
                ).dns.stream().map(s -> s.value).collect(Collectors.toList());
    }

    public ComputeBlade getUcsComputeBladeByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsComputeBladeByDn: {}", dn);
            return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                    ConfigResolveDnResponseComputeBlade.class)
                    .outconfig
                    .computeBlade;
    }

    public ComputeRackUnit getUcsComputeRackUnitByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsComputeRackUnitByDn: {}", dn);
        return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                ConfigResolveDnResponseComputeRackUnit.class)
                .outconfig
                .computeRackUnit;
    }

    public EquipmentChassis getUcsEquipmentChassisByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsEquipmentChassisByDn: {}", dn);
        return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                ConfigResolveDnResponseEquipmentChassis.class)
                .outconfig
                .equipmentChassis;
    }

    public EquipmentFex getUcsEquipmentFexByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsEquipmentFexByDn: {}", dn);
        return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                ConfigResolveDnResponseEquipmentFex.class)
                .outconfig
                .equipmentFex;
    }

    public EquipmentRackEnclosure getUcsEquipmentRackEnclosureByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsEquipmentRackEnclosureByDn: {}", dn);
        return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                ConfigResolveDnResponseEquipmentRackEnclosure.class)
                .outconfig
                .equipmentRackEnclosure;
    }

    public NetworkElement getUcsNetworkElementByDn(String cookie, String dn) throws ApiException {
        LOG.info("getUcsNetworkElementByDn: {}", dn);
        return client.getUcsXmlApiResponse(UcsXmlApiRequest.getConfigResolveDnRequest(cookie,dn,false),
                ConfigResolveDnResponseNetworkElement.class)
                .outconfig
                .networkElement;
    }

    public List<ComputeBlade> getUcsComputeBladeListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsComputeBladeListByClassId: {}", ClassId.computeBlade);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.computeBlade.name()),
                ConfigResolveClassResponseComputeBladeList.class
        ).computeBlades;
    }

    public List<ComputeRackUnit> getUcsComputeRackUnitListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsComputeBladeByClassId: {}" , ClassId.computeRackUnit);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.computeRackUnit.name()),
                ConfigResolveClassResponseComputeRackUnitList.class
        ).computeRackUnits;
    }

    public List<EquipmentChassis> getUcsEquipmentChassisListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentChassisListByClassId: {}", ClassId.equipmentChassis);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.equipmentChassis.name()),
                ConfigResolveClassResponseEquipmentChassisList.class
        ).equipmentChasses;
    }

    public List<EquipmentFex> getUcsEquipmentFexListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentFexListByClassId: {}", ClassId.equipmentFex);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.equipmentFex.name()),
                ConfigResolveClassResponseEquipmentFexList.class
        ).equipmentFexes;
    }

    public List<EquipmentRackEnclosure> getUcsEquipmentRackEnclosureListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsEquipmentRackEnclosureListByClassId: {}", ClassId.equipmentRackEnclosure);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.equipmentRackEnclosure.name()),
                ConfigResolveClassResponseEquipmentRackEnclosureList.class
        ).equipmentRackEnclosures;
    }

    public List<NetworkElement> getUcsNetworkElementListByClassId(String cookie) throws ApiException{
        LOG.info("getUcsNetworkElementListByClassId: {}", ClassId.networkElement);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,ClassId.networkElement.name()),
                ConfigResolveClassResponseNetworkElementList.class
        ).networkElements;
    }


}
