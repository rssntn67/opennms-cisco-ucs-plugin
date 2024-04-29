package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public interface ApiClientService {

    void disconnect() throws ApiException;

    UcsComputeBlade resolveUcsComputeBladeByDn(String dn) throws ApiException;
    UcsComputeRackUnit resolveUcsComputeRackUnitByDn(String dn) throws ApiException;
    UcsEquipmentChassis resolveUcsEquipmentChassisByDn(String dn) throws ApiException;
    UcsEquipmentFex resolveUcsEquipmentFexByDn(String dn) throws ApiException;
    UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByDn(String dn) throws ApiException;
    UcsNetworkElement resolveUcsNetworkElementByDn(String dn) throws ApiException;

    List<UcsComputeBlade> getUcsComputeBladeList() throws ApiException;
    List<UcsComputeRackUnit> getUcsComputeRackUnitList() throws ApiException;
    List<UcsEquipmentChassis> getUcsEquipmentChassisList() throws ApiException;
    List<UcsEquipmentFex> getUcsEquipmentFexList() throws ApiException;
    List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList() throws ApiException;
    List<UcsNetworkElement> getUcsNetworkElementList() throws ApiException;

    List<String> findDnByClassItem(UcsEntity.ClassItem classItem) throws ApiException;

}
