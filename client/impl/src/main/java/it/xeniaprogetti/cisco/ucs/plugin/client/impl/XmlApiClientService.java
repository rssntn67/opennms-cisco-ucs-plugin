package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEntity;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.Dn;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;

import java.util.List;
import java.util.stream.Collectors;

public class XmlApiClientService implements ApiClientService {

    private final ApiClientCredentials credentials;
    private final AaaApi aaaApi;
    private final ConfigApi configApi;

    public XmlApiClientService(ApiClientCredentials credentials) {
        ApiClient client = XmlApiClientProvider.getApiClient(credentials);
        this.credentials = credentials;
        this.aaaApi = new AaaApi(credentials, client);
        this.configApi = new ConfigApi(client);
    }


    private void checkCredentials() throws ApiException {
        if (aaaApi.getToken() == null) {
            aaaApi.login();
        } else if (aaaApi.isValidTokenAtLeastFor(1)
                && aaaApi.isValidTokenForLessThen(credentials.validity)) {
            aaaApi.refresh();
        } else if (aaaApi.isValidTokenForLessThen(0)) {
            aaaApi.login();
        }

    }

    @Override
    public void disconnect() throws ApiException {
        aaaApi.logout();
    }

    @Override
    public String getUcsXmlFromDn(String dn, boolean isHierarchical) throws ApiException {
        checkCredentials();
        return configApi.getUcsEntityByDn(aaaApi.getToken(), Dn.getDn(dn), isHierarchical);
    }

    @Override
    public UcsComputeBlade resolveUcsComputeBladeByResponse(String response) throws ApiException {
        return from(configApi.getUcsComputeBladeByResponse(response));
    }

    @Override
    public UcsComputeRackUnit resolveUcsComputeRackUnitByResponse(String response) throws ApiException {
        return from(configApi.getUcsComputeRackUnitByResponse(response));
    }

    @Override
    public UcsEquipmentChassis resolveUcsEquipmentChassisByResponse(String response) throws ApiException {
        return from(configApi.getUcsEquipmentChassisByResponse(response));
    }

    @Override
    public UcsEquipmentFex resolveUcsEquipmentFexByResponse(String response) throws ApiException {
        return from(configApi.getUcsEquipmentFexByResponse(response));
    }

    @Override
    public UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByResponse(String response) throws ApiException {
        return from(configApi.getUcsEquipmentRackEnclosureByResponse(response));
    }

    @Override
    public UcsNetworkElement resolveUcsNetworkElementByResponse(String response) throws ApiException {
        return from(configApi.getUcsNetworkElementByResponse(response));
    }


    @Override
    public List<UcsComputeBlade> getUcsComputeBladeList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsComputeBladeListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsComputeRackUnit> getUcsComputeRackUnitList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsComputeRackUnitListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentChassis> getUcsEquipmentChassisList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentChassisListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentFex> getUcsEquipmentFexList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentFexListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentRackEnclosureListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsNetworkElement> getUcsNetworkElementList() throws ApiException {
        checkCredentials();
        return configApi
                .getUcsNetworkElementListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findDnByClassItem(UcsEntity.ClassItem classItem) throws ApiException{
        checkCredentials();
        return configApi.getDnByClassId(aaaApi.getToken(), classItem);
    }

    private static UcsComputeBlade from(ComputeBlade compute) {
        if (compute == null)
            return null;
        return UcsComputeBlade.builder()
                .withDn(compute.dn)
                .withAdminPower(compute.adminPower)
                .withAdminState(compute.adminState)
                .withAssetTag(compute.assetTag)
                .withAssignedToDn(compute.assignedToDn)
                .withAssociation(compute.association)
                .withAvailability(compute.availability)
                .withAvailableMemory(compute.availableMemory)
                .withChassisId(compute.chassisId)
                .withCheckPoint(compute.checkPoint)
                .withConnPath(compute.connPath)
                .withConnStatus(compute.connStatus)
                .withDescr(compute.descr)
                .withDiscovery(compute.discovery)
                .withDiscoveryStatus(compute.discoveryStatus)
                .withFltAggr(compute.fltAggr)
                .withFsmDescr(compute.fsmDescr)
                .withFsmFlags(compute.fsmFlags)
                .withFsmPrev(compute.fsmPrev)
                .withFsmProgr(compute.fsmProgr)
                .withFsmRmtInvErrCode(compute.fsmRmtInvErrCode)
                .withFsmRmtInvErrDescr(compute.fsmRmtInvErrDescr)
                .withFsmRmtInvRslt(compute.fsmRmtInvRslt)
                .withFsmStageDescr(compute.fsmStageDescr)
                .withFsmStamp(compute.fsmStamp)
                .withFsmStatus(compute.fsmStatus)
                .withFsmTry(compute.fsmTry)
                .withIntId(compute.intId)
                .withKmipFault(compute.kmipFault)
                .withKmipFaultDescription(compute.kmipFaultDescription)
                .withLc(compute.lc)
                .withLcTs(compute.lcTs)
                .withLocalId(compute.localId)
                .withLowVoltageMemory(compute.lowVoltageMemory)
                .withManagingInst(compute.managingInst)
                .withMemorySpeed(compute.memorySpeed)
                .withMfgTime(compute.mfgTime)
                .withModel(compute.model)
                .withName(compute.name)
                .withNumOf40GAdaptorsWithOldFw(compute.numOf40GAdaptorsWithOldFw)
                .withNumOf40GAdaptorsWithUnknownFw(compute.numOf40GAdaptorsWithUnknownFw)
                .withNumOfAdaptors(compute.numOfAdaptors)
                .withNumOfCores(compute.numOfCores)
                .withNumOfCoresEnabled(compute.numOfCoresEnabled)
                .withNumOfCpus(compute.numOfCpus)
                .withNumOfEthHostIfs(compute.numOfEthHostIfs)
                .withNumOfFcHostIfs(compute.numOfFcHostIfs)
                .withNumOfThreads(compute.numOfThreads)
                .withOperPower(compute.operPower)
                .withOperPwrTransSrc(compute.operPwrTransSrc)
                .withOperQualifier(compute.operQualifier)
                .withOperQualifierReason(compute.operQualifierReason)
                .withOperState(compute.operState)
                .withOperability(compute.operability)
                .withOriginalUuid(compute.originalUuid)
                .withPartNumber(compute.partNumber)
                .withPolicyLevel(compute.policyLevel)
                .withPolicyOwner(compute.policyOwner)
                .withPresence(compute.presence)
                .withRevision(compute.revision)
                .withScaledMode(compute.scaledMode)
                .withSerial(compute.serial)
                .withServerId(compute.serverId)
                .withSlotId(compute.slotId)
                .withStorageOperQualifier(compute.storageOperQualifier)
                .withTotalMemory(compute.totalMemory)
                .withUsrLbl(compute.usrLbl)
                .withUuid(compute.uuid)
                .withVendor(compute.vendor)
                .withVid(compute.vid)
                .build();
    }

    private static UcsComputeRackUnit from(ComputeRackUnit compute) {
        if (compute == null)
            return null;
        return UcsComputeRackUnit.builder()
                .withDn(compute.dn)
                .withAdminPower(compute.adminPower)
                .withAdminState(compute.adminState)
                .withAssetTag(compute.assetTag)
                .withAssignedToDn(compute.assignedToDn)
                .withAssociation(compute.association)
                .withAvailability(compute.availability)
                .withAvailableMemory(compute.availableMemory)
                .withCheckPoint(compute.checkPoint)
                .withConnPath(compute.connPath)
                .withConnStatus(compute.connStatus)
                .withDescr(compute.descr)
                .withDiscovery(compute.discovery)
                .withDiscoveryStatus(compute.discoveryStatus)
                .withEnclosureId(compute.enclosureId)
                .withFanSpeedConfigStatus(compute.fanSpeedConfigStatus)
                .withFanSpeedPolicyFault(compute.fanSpeedPolicyFault)
                .withFltAggr(compute.fltAggr)
                .withFsmDescr(compute.fsmDescr)
                .withFsmFlags(compute.fsmFlags)
                .withFsmPrev(compute.fsmPrev)
                .withFsmProgr(compute.fsmProgr)
                .withFsmRmtInvErrCode(compute.fsmRmtInvErrCode)
                .withFsmRmtInvErrDescr(compute.fsmRmtInvErrDescr)
                .withFsmRmtInvRslt(compute.fsmRmtInvRslt)
                .withFsmStageDescr(compute.fsmStageDescr)
                .withFsmStamp(compute.fsmStamp)
                .withFsmStatus(compute.fsmStatus)
                .withFsmTry(compute.fsmTry)
                .withId(compute.id)
                .withIntId(compute.intId)
                .withKmipFault(compute.kmipFault)
                .withKmipFaultDescription(compute.kmipFaultDescription)
                .withLc(compute.lc)
                .withLcTs(compute.lcTs)
                .withLocalId(compute.localId)
                .withLowVoltageMemory(compute.lowVoltageMemory)
                .withManagingInst(compute.managingInst)
                .withMemorySpeed(compute.memorySpeed)
                .withMfgTime(compute.mfgTime)
                .withModel(compute.model)
                .withName(compute.name)
                .withNumOf40GAdaptorsWithOldFw(compute.numOf40GAdaptorsWithOldFw)
                .withNumOf40GAdaptorsWithUnknownFw(compute.numOf40GAdaptorsWithUnknownFw)
                .withNumOfAdaptors(compute.numOfAdaptors)
                .withNumOfCores(compute.numOfCores)
                .withNumOfCoresEnabled(compute.numOfCoresEnabled)
                .withNumOfCpus(compute.numOfCpus)
                .withNumOfEthHostIfs(compute.numOfEthHostIfs)
                .withNumOfFcHostIfs(compute.numOfFcHostIfs)
                .withNumOfThreads(compute.numOfThreads)
                .withOperPower(compute.operPower)
                .withOperPwrTransSrc(compute.operPwrTransSrc)
                .withOperQualifier(compute.operQualifier)
                .withOperQualifierReason(compute.operQualifierReason)
                .withOperState(compute.operState)
                .withOperability(compute.operability)
                .withOriginalUuid(compute.originalUuid)
                .withPartNumber(compute.partNumber)
                .withPhysicalSecurity(compute.physicalSecurity)
                .withPolicyLevel(compute.policyLevel)
                .withPolicyOwner(compute.policyOwner)
                .withPresence(compute.presence)
                .withRevision(compute.revision)
                .withSerial(compute.serial)
                .withServerId(compute.serverId)
                .withSlotId(compute.slotId)
                .withStorageOperQualifier(compute.storageOperQualifier)
                .withTotalMemory(compute.totalMemory)
                .withUsrLbl(compute.usrLbl)
                .withUuid(compute.uuid)
                .withVendor(compute.vendor)
                .withVersionHolder(compute.versionHolder)
                .withVethStatus(compute.vethStatus)
                .withVid(compute.vid)
                .build();
    }

    private static UcsEquipmentChassis from(EquipmentChassis equipment) {
        if (equipment == null)
            return null;
        return UcsEquipmentChassis.builder()
                .withDn(equipment.dn)
                .withAckProgressIndicator(equipment.ackProgressIndicator)
                .withAdminState(equipment.adminState)
                .withAssetTag(equipment.assetTag)
                .withAssignedToDn(equipment.assignedToDn)
                .withAssociation(equipment.association)
                .withAvailability(equipment.availability)
                .withConfigState(equipment.configState)
                .withConnPath(equipment.connPath)
                .withConnStatus(equipment.connStatus)
                .withDiscovery(equipment.discovery)
                .withDiscoveryStatus(equipment.discoveryStatus)
                .withFabricEpDn(equipment.fabricEpDn)
                .withFanSpeedConfigState(equipment.fanSpeedConfigState)
                .withFltAggr(equipment.fltAggr)
                .withFsmDescr(equipment.fsmDescr)
                .withFsmFlags(equipment.fsmFlags)
                .withFsmPrev(equipment.fsmPrev)
                .withFsmProgr(equipment.fsmProgr)
                .withFsmRmtInvErrCode(equipment.fsmRmtInvErrCode)
                .withFsmRmtInvErrDescr(equipment.fsmRmtInvErrDescr)
                .withFsmRmtInvRslt(equipment.fsmRmtInvRslt)
                .withFsmStageDescr(equipment.fsmStageDescr)
                .withFsmStamp(equipment.fsmStamp)
                .withFsmStatus(equipment.fsmStatus)
                .withFsmTry(equipment.fsmTry)
                .withId(equipment.id)
                .withLcTs(equipment.lcTs)
                .withLicGP(equipment.licGP)
                .withLicState(equipment.licState)
                .withManagingInst(equipment.managingInst)
                .withMfgTime(equipment.mfgTime)
                .withModel(equipment.model)
                .withOperQualifier(equipment.operQualifier)
                .withOperQualifierReason(equipment.operQualifierReason)
                .withOperState(equipment.operState)
                .withOperability(equipment.operability)
                .withPartNumber(equipment.partNumber)
                .withPower(equipment.power)
                .withPresence(equipment.presence)
                .withRevision(equipment.revision)
                .withSeepromOperState(equipment.seepromOperState)
                .withSerial(equipment.serial)
                .withServiceState(equipment.serviceState)
                .withThermal(equipment.thermal)
                .withThermalStateQualifier(equipment.thermalStateQualifier)
                .withUsrLbl(equipment.usrLbl)
                .withVendor(equipment.vendor)
                .withVersionHolder(equipment.versionHolder)
                .withVid(equipment.vid)
                .build();
    }

    private static UcsEquipmentFex from(EquipmentFex equipment) {
        if (equipment == null)
            return null;
        return UcsEquipmentFex.builder()
                .withDn(equipment.dn)
                .withAdminPowerState(equipment.adminPowerState)
                .withAdminState(equipment.adminState)
                .withConfigState(equipment.configState)
                .withFltAggr(equipment.fltAggr)
                .withFsmDescr(equipment.fsmDescr)
                .withFsmPrev(equipment.fsmPrev)
                .withFsmProgr(equipment.fsmProgr)
                .withFsmRmtInvErrCode(equipment.fsmRmtInvErrCode)
                .withFsmRmtInvErrDescr(equipment.fsmRmtInvErrDescr)
                .withFsmRmtInvRslt(equipment.fsmRmtInvRslt)
                .withFsmStageDescr(equipment.fsmStageDescr)
                .withFsmStamp(equipment.fsmStamp)
                .withFsmStatus(equipment.fsmStatus)
                .withFsmTry(equipment.fsmTry)
                .withId(equipment.id)
                .withLicGP(equipment.licGP)
                .withLicState(equipment.licState)
                .withModel(equipment.model)
                .withOperQualifier(equipment.operQualifier)
                .withOperQualifierReason(equipment.operQualifierReason)
                .withOperState(equipment.operState)
                .withOperability(equipment.operability)
                .withPower(equipment.power)
                .withPresence(equipment.presence)
                .withRevision(equipment.revision)
                .withSerial(equipment.serial)
                .withSwitchId(equipment.switchId)
                .withThermal(equipment.thermal)
                .withUsrLbl(equipment.usrLbl)
                .withVendor(equipment.vendor)
                .withVoltage(equipment.voltage)
                .build();
    }

    private static UcsEquipmentRackEnclosure from(EquipmentRackEnclosure equipment) {
        if (equipment == null)
            return null;
        return UcsEquipmentRackEnclosure.builder()
                .withDn(equipment.dn)
                .withAssetTag(equipment.assetTag)
                .withFltAggr(equipment.fltAggr)
                .withId(equipment.id)
                .withMfgTime(equipment.mfgTime)
                .withModel(equipment.model)
                .withOperQualifierReason(equipment.operQualifierReason)
                .withOperability(equipment.operability)
                .withPartNumber(equipment.partNumber)
                .withPresence(equipment.presence)
                .withRevision(equipment.revision)
                .withSerial(equipment.serial)
                .withVendor(equipment.vendor)
                .withVid(equipment.vid)
                .build();
    }

    private static UcsNetworkElement from(NetworkElement network) {
        if (network == null)
            return null;
        return UcsNetworkElement.builder()
                .withDn(network.dn)
                .withAdminEvacState(network.adminEvacState)
                .withAdminInbandIfState(network.adminInbandIfState)
                .withDiffMemory(network.diffMemory)
                .withExpectedMemory(network.expectedMemory)
                .withFltAggr(network.fltAggr)
                .withForceEvac(network.forceEvac)
                .withId(network.id)
                .withInbandIfGw(network.inbandIfGw)
                .withInbandIfIp(network.inbandIfIp)
                .withInbandIfMask(network.inbandIfMask)
                .withInbandIfVnet(network.inbandIfVnet)
                .withInventoryStatus(network.inventoryStatus)
                .withMinActiveFan(network.minActiveFan)
                .withModel(network.model)
                .withOobIfGw(network.oobIfGw)
                .withOobIfIp(network.oobIfIp)
                .withOobIfMac(network.oobIfMac)
                .withOobIfMask(network.oobIfMask)
                .withOperEvacState(network.operEvacState)
                .withOperability(network.operability)
                .withRevision(network.revision)
                .withSerial(network.serial)
                .withShutdownFanRemoveal(network.shutdownFanRemoveal)
                .withThermal(network.thermal)
                .withTotalMemory(network.totalMemory)
                .withVendor(network.vendor)
                .build();
    }


}
