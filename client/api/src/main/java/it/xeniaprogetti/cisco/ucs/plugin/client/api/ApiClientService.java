package it.xeniaprogetti.cisco.ucs.plugin.client.api;

import java.util.List;

public interface ApiClientService {

    UcsComputeBlade resolveUcsComputeBladeByDn(String dn) throws ApiException;
    UcsComputeRackUnit resolveUcsComputeRackUnitByDn(String dn) throws ApiException;
    UcsEquipmentChassis resolveUcsEquipmentChassisByDn(String dn) throws ApiException;
    UcsEquipmentFex resolveUcsEquipmentFexByDn(String dn) throws ApiException;
    UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByDn(String dn) throws ApiException;
    UcsNetworkElement resolveUcsNetworkElementByDn(String dn) throws ApiException;

    List<UcsComputeBlade> getUcsComputeBladeList(String dn) throws ApiException;
    List<UcsComputeRackUnit> getUcsComputeRackUnitList(String dn) throws ApiException;
    List<UcsEquipmentChassis> getUcsEquipmentChassisList(String dn) throws ApiException;
    List<UcsEquipmentFex> getUcsEquipmentFexList(String dn) throws ApiException;
    List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList(String dn) throws ApiException;
    List<UcsNetworkElement> getUcsNetworkElementList(String dn) throws ApiException;

}
