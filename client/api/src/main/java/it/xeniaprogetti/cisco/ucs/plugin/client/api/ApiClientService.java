package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public interface ApiClientService {

    void disconnect() throws ApiException;

    String getUcsXmlFromDn(String dn, boolean isHierarchical) throws ApiException;

    UcsComputeBlade resolveUcsComputeBladeByResponse(String response) throws ApiException;
    UcsComputeRackUnit resolveUcsComputeRackUnitByResponse(String response) throws ApiException;
    UcsEquipmentChassis resolveUcsEquipmentChassisByResponse(String response) throws ApiException;
    UcsEquipmentFex resolveUcsEquipmentFexByResponse(String response) throws ApiException;
    UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByResponse(String response) throws ApiException;
    UcsNetworkElement resolveUcsNetworkElementByResponse(String response) throws Exception;

    List<UcsComputeBlade> getUcsComputeBladeList() throws ApiException;
    List<UcsComputeRackUnit> getUcsComputeRackUnitList() throws ApiException;
    List<UcsEquipmentChassis> getUcsEquipmentChassisList() throws ApiException;
    List<UcsEquipmentFex> getUcsEquipmentFexList() throws ApiException;
    List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList() throws ApiException;
    List<UcsNetworkElement> getUcsNetworkElementList() throws ApiException;

    List<String> findDnByClassItem(UcsEntity.ClassItem classItem) throws ApiException;

    List<UcsIpPoolPooled> findUcsIpPoolPooled() throws ApiException;
}
