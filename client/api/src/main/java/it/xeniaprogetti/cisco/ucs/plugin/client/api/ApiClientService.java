package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ApiClientService {

    void disconnect() throws ApiException;

    String getUcsXmlFromDn(String dn, boolean isHierarchical) throws ApiException;

    UcsComputeBlade resolveUcsComputeBladeByResponse(String response) throws ApiException;
    UcsComputeRackUnit resolveUcsComputeRackUnitByResponse(String response) throws ApiException;
    UcsEquipmentChassis resolveUcsEquipmentChassisByResponse(String response) throws ApiException;
    UcsEquipmentFex resolveUcsEquipmentFexByResponse(String response) throws ApiException;
    UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByResponse(String response) throws ApiException;
    UcsNetworkElement resolveUcsNetworkElementByResponse(String response) throws ApiException;

    List<UcsComputeBlade> getUcsComputeBladeList() throws ApiException;
    List<UcsComputeRackUnit> getUcsComputeRackUnitList() throws ApiException;
    List<UcsEquipmentChassis> getUcsEquipmentChassisList() throws ApiException;
    List<UcsEquipmentFex> getUcsEquipmentFexList() throws ApiException;
    List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList() throws ApiException;
    List<UcsNetworkElement> getUcsNetworkElementList() throws ApiException;

    List<String> findDnByClassItem(UcsEnums.NamingClassId classId) throws ApiException;

    List<UcsIpPoolPooled> findUcsIpPoolPooled() throws ApiException;

    List<UcsFault> findAllUcsFaults() throws ApiException;
    List<UcsFault> findUcsFaultsFromDate(final OffsetDateTime from) throws ApiException;

    UcsManager getUcsManager() throws ApiException;

    UcsNetworkElementStats getNetworkElementStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException;
    UcsEquipmentStats getUcsEquipmentStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException;
    UcsComputeStats getUcsComputeStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException;
    
}
