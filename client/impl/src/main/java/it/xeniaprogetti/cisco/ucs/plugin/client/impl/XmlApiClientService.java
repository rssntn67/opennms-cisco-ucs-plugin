package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.*;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.FaultApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.IpApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.StatsApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.equipment.EquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault.FaultInst;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.network.NetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.LsServer;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortMcastStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorVnicStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalCompletionStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalProtocolStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalReceiveStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputePCIeFatalStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentFanModuleStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentIOCardStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentNetworkElementFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentPsuInputStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentPsuStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherLossStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherNiErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherPauseStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherRxStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EtherTxStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.FcErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.FcStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.MemoryErrorStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.MemoryUnitEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ProcessorEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ProcessorErrorStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.StorageDiskEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.StorageSsdHealthStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwSystemStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class XmlApiClientService implements ApiClientService {

    Logger LOG = LoggerFactory.getLogger(XmlApiClientService.class);
    private final AaaApi aaaApi;
    private final ConfigApi configApi;
    private final IpApi ipApi;
    private final FaultApi faultApi;
    private final StatsApi statsApi;

    public XmlApiClientService(AaaApi aaaApi) {
        this.aaaApi = Objects.requireNonNull(aaaApi);
        this.configApi = new ConfigApi(aaaApi.getClient(), aaaApi.getUrl());
        this.ipApi = new IpApi(aaaApi.getClient(), aaaApi.getUrl());
        this.faultApi = new FaultApi(aaaApi.getClient(), aaaApi.getUrl());
        this.statsApi = new StatsApi(aaaApi.getClient(), aaaApi.getUrl());
    }

    protected void checkSession() throws ApiException {
        aaaApi.checkSession();
    }

    @Override
    public void disconnect() {
        try {
            aaaApi.logout();
        } catch (ApiException e) {
            LOG.warn("disconnect: logout fail:{}, {}", e.getMessage(), e.getResponseBody());
        }
    }

    @Override
    public String getUcsXmlFromDn(String dn, boolean isHierarchical) throws ApiException {
        checkSession();
        return configApi.getUcsEntityByDn(aaaApi.getToken(), dn, isHierarchical);
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
        checkSession();
        return configApi
                .getUcsComputeBladeListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsComputeRackUnit> getUcsComputeRackUnitList() throws ApiException {
        checkSession();
        return configApi
                .getUcsComputeRackUnitListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentChassis> getUcsEquipmentChassisList() throws ApiException {
        checkSession();
        return configApi
                .getUcsEquipmentChassisListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentFex> getUcsEquipmentFexList() throws ApiException {
        checkSession();
        return configApi
                .getUcsEquipmentFexListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList() throws ApiException {
        checkSession();
        return configApi
                .getUcsEquipmentRackEnclosureListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsNetworkElement> getUcsNetworkElementList() throws ApiException {
        checkSession();
        return configApi
                .getUcsNetworkElementListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findDnByClassItem(UcsEnums.NamingClassId classId) throws ApiException{
        checkSession();
        return configApi.getDnByClassId(aaaApi.getToken(), classId);
    }

    @Override
    public List<UcsIpPoolPooled> findUcsIpPoolPooled() throws ApiException {
        checkSession();
        IpPoolUniverse ipPoolUniverse = ipApi.getIpPoolUniverse(aaaApi.getToken());
        List<UcsIpPoolPooled> list = new ArrayList<>();
        for (IpPoolAddr pool: ipPoolUniverse.ippoolAddr) {
            if (!pool.assigned.equals("yes"))
                continue;
            UcsDn assignedProfileToDn = Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.assignedToDn)));
            LsServer lsServer = ipApi.getLsServer(aaaApi.getToken(), assignedProfileToDn.value);
            if (lsServer.pnDn.isEmpty())
                continue;
            UcsDn poolDn = Objects.requireNonNull(UcsDn.getParentDn(UcsDn.getDn(pool.ippoolPoolable.poolDn)));
            IpPoolPooled ipPoolPooled = ipApi.getIpPoolPooled(aaaApi.getToken(), pool.ippoolPoolable.poolDn);

            list.add(UcsIpPoolPooled.builder()
                    .withAddr(ipPoolPooled.id)
                    .withDefGw(ipPoolPooled.defGw)
                    .withSubnet(ipPoolPooled.subnet)
                    .withAssignedDeviceToDn(lsServer.pnDn)
                    .withAssignedProfileToDn(assignedProfileToDn.value)
                    .withPoolDn(poolDn.value)
                    .build());

        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<UcsFault> findAllUcsFaults() throws ApiException{
        checkSession();
        return faultApi.getUcsFaults(aaaApi.getToken()).stream().map(XmlApiClientService::from).collect(Collectors.toList());
    }

    @Override
    public List<UcsFault> findUcsFaultsFromDate(final OffsetDateTime from) throws ApiException {
        List<UcsXmlApiRequest.InFilter> filters = new ArrayList<>();
        OffsetDateTime to = OffsetDateTime.now();
        OffsetDateTime cur = from;
        while (cur.isBefore(to)) {
            filters.add(
                UcsXmlApiRequest.getWCardFilter(
                    UcsEnums.NamingClassId.faultInst,
                "lastTransition",
                        cur.toString().substring(0,cur.toString().indexOf("T")+1)+".*")
            );
            cur = cur.plusDays(1);
        }
        filters.add(
                UcsXmlApiRequest.getWCardFilter(
                        UcsEnums.NamingClassId.faultInst,
                        "lastTransition",
                        to.toString().substring(0,to.toString().indexOf("T")+1)+".*")
        );
        UcsXmlApiRequest.InFilter filter = UcsXmlApiRequest.getOrFilter(filters.toArray(new UcsXmlApiRequest.InFilter[0]));
        checkSession();
        return faultApi
                .getUcsFaultsByFilter(aaaApi.getToken(), filter)
                .stream()
                .map(XmlApiClientService::from)
//                .filter(ucsFault ->
//                        ucsFault.lastTransition.isAfter(from) && ucsFault.lastTransition.isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public UcsManager getUcsManager() throws ApiException {
        return UcsManager
                .builder()
                .witLabel(UcsUtils.getLabelFromUrl(aaaApi.getUrl()))
                .withAddress(UcsUtils.getIpAddressFromUrl(aaaApi.getUrl())).
                build();
    }

    @Override
    public UcsDataCollection getUcsDataCollection(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException {
        LOG.debug("getUcsDataCollection: {}", collectMap);
        UcsSwEnvStats swEnvStats = null;
        UcsSwSystemStats swSystemStats = null;
        UcsSwCardEnvStats swCardEnvStats = null;
        UcsEquipmentChassisStats ucsEquipmentChassisStats = null;
        final List<UcsEquipmentNetworkElementFanStats> fanStats = new ArrayList<>();
        final List<UcsFcStats> fcStats = new ArrayList<>();
        final List<UcsFcErrStats> fcErrStats = new ArrayList<>();
        final List<UcsProcessorEnvStats> ucsProcessorEnvStats = new ArrayList<>();
        final List<UcsProcessorErrorStats> ucsProcessorErrorStats = new ArrayList<>();
        UcsComputeMbTempStats ucsComputeMbTempStats = null;
        UcsComputeMbPowerStats ucsComputeMbPowerStats = null;
        final List<UcsEtherRxStats> ucsEtherRxStats = new ArrayList<>();
        final List<UcsEtherTxStats> ucsEtherTxStats = new ArrayList<>();
        final List<UcsEquipmentPsuInputStats> ucsEquipmentPsuInputStats = new ArrayList<>();
        final List<UcsEquipmentPsuStats> ucsEquipmentPsuStats = new ArrayList<>();
        final List<UcsEquipmentIOCardStats> ucsEquipmentIOCardStats = new ArrayList<>();
        final List<UcsEtherErrStats> ucsEtherErrStats = new ArrayList<>();
        final List<UcsEtherPauseStats> ucsEtherPauseStats = new ArrayList<>();
        final List<UcsEtherLossStats> ucsEtherLossStats = new ArrayList<>();
        final List<UcsEtherNiErrStats> ucsEtherNiErrStats = new ArrayList<>();
        final List<UcsEquipmentFanModuleStats> ucsEquipmentFanModuleStats = new ArrayList<>();
        final List<UcsEquipmentFanStats> ucsEquipmentFanStats = new ArrayList<>();
        final List<UcsAdaptorEthPortErrStats> ucsAdaptorEthPortErrStats = new ArrayList<>();
        final List<UcsAdaptorEthPortMcastStats> ucsAdaptorEthPortMcastStats = new ArrayList<>();
        final List<UcsAdaptorEthPortStats> ucsAdaptorEthPortStats = new ArrayList<>();
        final List<UcsAdaptorVnicStats> ucsAdaptorVnicStats = new ArrayList<>();
        final List<UcsStorageDiskEnvStats> ucsStorageDiskEnvStats = new ArrayList<>();
        final List<UcsStorageSsdHealthStats> ucsStorageSsdHealthStats = new ArrayList<>();
        UcsComputePCIeFatalCompletionStats ucsComputePCIeFatalCompletionStats = null;
        UcsComputePCIeFatalProtocolStats ucsComputePCIeFatalProtocolStats = null;
        UcsComputePCIeFatalReceiveStats ucsComputePCIeFatalReceiveStats = null;
        UcsComputePCIeFatalStats ucsComputePCIeFatalStats = null;
        final List<UcsMemoryErrorStats> ucsMemoryErrorStats = new ArrayList<>();
        final List<UcsMemoryUnitEnvStats> ucsMemoryUnitEnvStats = new ArrayList<>();

        for (String dn: collectMap.keySet()) {
            for (UcsEnums.NamingClassId classId: collectMap.get(dn)) {
                LOG.debug("getUcsDataCollection: parsing dn={}, type={}", dn, classId);
                UcsXmlApiRequest.InFilter filter = UcsXmlApiRequest.getWCardFilter(
                        classId,
                        "dn",
                        dn+".*");
                checkSession();
                switch (classId) {
                    case swEnvStats:
                        List<SwEnvStats> listA = statsApi.getSwEnvStats(aaaApi.getToken(), filter);
                        if (!listA.isEmpty()) {
                            swEnvStats = from(listA.get(0));
                        }
                        break;
                    case swSystemStats:
                        List<SwSystemStats> listB = statsApi.getSwSystemStats(aaaApi.getToken(), filter);
                        if (!listB.isEmpty()) {
                            swSystemStats = from(listB.get(0));
                        }
                        break;
                    case swCardEnvStats:
                        List<SwCardEnvStats> listC = statsApi.getSwCardEnvStats(aaaApi.getToken(), filter);
                        if (!listC.isEmpty()) {
                            swCardEnvStats = from(listC.get(0));
                        }
                        break;
                    case equipmentNetworkElementFanStats:
                        statsApi.getEquipmentNetworkElementFanStats(aaaApi.getToken(), filter)
                                .forEach(e -> fanStats.add(from(e)));
                        break;
                    case fcStats:
                        statsApi.getFcStats(aaaApi.getToken(), filter)
                                .forEach(f -> fcStats.add(from(f)) );
                        break;
                    case fcErrStats:
                        statsApi.getFcErrStats(aaaApi.getToken(), filter)
                                .forEach(f -> fcErrStats.add(from(f)) );
                        break;
                    case equipmentChassisStats:
                        List<EquipmentChassisStats> listD = statsApi.getEquipmentChassisStats(aaaApi.getToken(), filter);
                        if (!listD.isEmpty()) {
                            ucsEquipmentChassisStats =  from(listD.get(0));
                        }
                        break;
                    case processorEnvStats:
                        statsApi.getProcessorEnvStats(aaaApi.getToken(), filter ).forEach(p -> ucsProcessorEnvStats.add(from(p)));
                        break;
                    case processorErrorStats:
                        statsApi.getProcessorErrorStats(aaaApi.getToken(), filter ).forEach(p -> ucsProcessorErrorStats.add(from(p)));
                        break;
                    case computeMbPowerStats:
                        List<ComputeMbPowerStats> listE = statsApi.getComputeMbPowerStats(aaaApi.getToken(), filter);
                        if (!listE.isEmpty()) {
                            ucsComputeMbPowerStats = from(listE.get(0));
                        }
                        break;
                    case computeMbTempStats:
                        List<ComputeMbTempStats> listF = statsApi.getComputeMbTempStats(aaaApi.getToken(), filter);
                        if (!listF.isEmpty()) {
                            ucsComputeMbTempStats = from(listF.get(0));
                        }
                        break;
                    case computePCIeFatalCompletionStats:
                        List<ComputePCIeFatalCompletionStats> listG = statsApi.getComputePCIeFatalCompletionStats(aaaApi.getToken(), filter);
                        if (!listG.isEmpty()) {
                            ucsComputePCIeFatalCompletionStats = from(listG.get(0));
                        }
                        break;
                    case computePCIeFatalProtocolStats:
                        List<ComputePCIeFatalProtocolStats> listH = statsApi.getComputePCIeFatalProtocolStats(aaaApi.getToken(), filter);
                        if (!listH.isEmpty()) {
                            ucsComputePCIeFatalProtocolStats = from(listH.get(0));
                        }
                        break;
                    case computePCIeFatalReceiveStats:
                        List<ComputePCIeFatalReceiveStats> listK = statsApi.getComputePCIeFatalReceiveStats(aaaApi.getToken(), filter);
                        if (!listK.isEmpty()) {
                            ucsComputePCIeFatalReceiveStats = from(listK.get(0));
                        }
                        break;
                    case computePCIeFatalStats:
                        List<ComputePCIeFatalStats> listJ = statsApi.getPCIeFatalStats(aaaApi.getToken(), filter);
                        if (!listJ.isEmpty()) {
                            ucsComputePCIeFatalStats = from(listJ.get(0));
                        }
                        break;
                    case etherRxStats:
                        statsApi.getEtherRxStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherRxStats.add(from(e)));
                        break;
                    case etherTxStats:
                        statsApi.getEtherTxStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherTxStats.add(from(e)));
                        break;
                    case equipmentPsuInputStats:
                        statsApi.getEquipmentPsuInputStats(aaaApi.getToken(), filter).forEach(e -> ucsEquipmentPsuInputStats.add(from(e)));
                        break;
                    case equipmentPsuStats:
                        statsApi.getEquipmentPsuStats(aaaApi.getToken(), filter).forEach(e -> ucsEquipmentPsuStats.add(from(e)));
                        break;
                    case equipmentIOCardStats:
                        statsApi.getEquipmentIOCardStats(aaaApi.getToken(), filter).forEach(e -> ucsEquipmentIOCardStats.add(from(e)));
                        break;
                    case etherErrStats:
                        statsApi.getEtherErrStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherErrStats.add(from(e)));
                        break;
                    case etherLossStats:
                        statsApi.getEtherLossStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherLossStats.add(from(e)));
                        break;
                    case etherPauseStats:
                        statsApi.getEtherPauseStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherPauseStats.add(from(e)));
                        break;
                    case etherNiErrStats:
                        statsApi.getEtherNiErrStats(aaaApi.getToken(), filter).forEach(e -> ucsEtherNiErrStats.add(from(e)));
                        break;
                    case equipmentFanModuleStats:
                        statsApi.getEquipmentFanModuleStats(aaaApi.getToken(), filter).forEach(e -> ucsEquipmentFanModuleStats.add(from(e)));
                        break;
                    case equipmentFanStats:
                        statsApi.getEquipmentFanStats(aaaApi.getToken(), filter).forEach(e -> ucsEquipmentFanStats.add(from(e)));
                        break;
                    case adaptorEthPortErrStats:
                        statsApi.getAdaptorEthPortErrStats(aaaApi.getToken(), filter).forEach(e -> ucsAdaptorEthPortErrStats.add(from(e)));
                        break;
                    case adaptorEthPortMcastStats:
                        statsApi.getAdaptorEthPortMcastStats(aaaApi.getToken(), filter).forEach(e -> ucsAdaptorEthPortMcastStats.add(from(e)));
                        break;
                    case adaptorEthPortStats:
                        statsApi.getAdaptorEthPortStats(aaaApi.getToken(), filter).forEach(e -> ucsAdaptorEthPortStats.add(from(e)));
                        break;
                    case adaptorVnicStats:
                        statsApi.getAdaptorVnicStats(aaaApi.getToken(), filter).forEach(e -> ucsAdaptorVnicStats.add(from(e)));
                        break;
                    case storageDiskEnvStats:
                        statsApi.getStorageDiskEnvStats(aaaApi.getToken(), filter).forEach(e -> ucsStorageDiskEnvStats.add(from(e)));
                        break;
                    case storageSsdHealthStats:
                        statsApi.getStorageSsdHealthStats(aaaApi.getToken(), filter).forEach(e -> ucsStorageSsdHealthStats.add(from(e)));
                        break;
                    case memoryErrorStats:
                        statsApi.getMemoryErrorStats(aaaApi.getToken(), filter).forEach(m -> ucsMemoryErrorStats.add(from(m)));
                        break;
                    case memoryUnitEnvStats:
                        statsApi.getMemoryUnitEnvStats(aaaApi.getToken(), filter).forEach(m -> ucsMemoryUnitEnvStats.add(from(m)));
                        break;
                    default:
                        break;
                }
            }
        }
        return UcsDataCollection.builder()
                .withUcsSwEnvStats(swEnvStats)
                .withUcsSwSystemStats(swSystemStats)
                .withUcsSwCardEnvStats(swCardEnvStats)
                .withUcsEquipmentNetworkElementFanStatsList(fanStats)
                .withUcsFcStats(fcStats)
                .withUcsFcErrStats(fcErrStats)
                .withUcsEquipmentChassisStats(ucsEquipmentChassisStats)
                .withUcsProcessorEnvStats(ucsProcessorEnvStats)
                .withUcsProcessorErrorStats(ucsProcessorErrorStats)
                .withUcsComputeMbPowerStats(ucsComputeMbPowerStats)
                .withUcsComputeTempStats(ucsComputeMbTempStats)
                .withUcsEtherRxStats(ucsEtherRxStats)
                .withUcsEtherTxStats(ucsEtherTxStats)
                .withUcsEquipmentPsuInputStats(ucsEquipmentPsuInputStats)
                .withUcsEquipmentPsuStats(ucsEquipmentPsuStats)
                .withUcsEquipmentIOCardStats(ucsEquipmentIOCardStats)
                .withUcsEtherErrStats(ucsEtherErrStats)
                .withUcsEtherLossStats(ucsEtherLossStats)
                .withUcsEtherPauseStats(ucsEtherPauseStats)
                .withUcsEtherNiErrStats(ucsEtherNiErrStats)
                .withUcsEquipmentFanModuleStats(ucsEquipmentFanModuleStats)
                .withUcsEquipmentFanStats(ucsEquipmentFanStats)
                .withUcsAdaptorEthPortErrStats(ucsAdaptorEthPortErrStats)
                .withUcsAdaptorEthPortMcastStats(ucsAdaptorEthPortMcastStats)
                .withUcsAdaptorEthPortStats(ucsAdaptorEthPortStats)
                .withUcsAdaptorVNicStats(ucsAdaptorVnicStats)
                .withUcsStorageDiskEnvStats(ucsStorageDiskEnvStats)
                .withUcsStorageSsdHealthStats(ucsStorageSsdHealthStats)
                .withUcsComputePCIeFatalCompletionStats(ucsComputePCIeFatalCompletionStats)
                .withUcsComputePCIeFatalProtocolStats(ucsComputePCIeFatalProtocolStats)
                .withUcsComputePCIeFatalReceiveStats(ucsComputePCIeFatalReceiveStats)
                .withUcsComputePCIeFatalStats(ucsComputePCIeFatalStats)
                .withUcsUcsMemoryErrorStats(ucsMemoryErrorStats)
                .withUcsUcsMemoryUnitEnvStats(ucsMemoryUnitEnvStats)
                .build();
    }

    private UcsMemoryUnitEnvStats from(MemoryUnitEnvStats m) {
        return UcsMemoryUnitEnvStats.builder()
                .withDn(m.dn)
                .withIntervals(m.intervals)
                .withSuspect(m.suspect)
                .withThresholded(m.thresholded)
                .withTimeCollected(m.timeCollected)
                .withUpdate(m.update)
                .withTemperature(m.temperature)
                .build();
    }

    private UcsMemoryErrorStats from(MemoryErrorStats m) {
        return UcsMemoryErrorStats.builder()
                .withDn(m.dn)
                .withIntervals(m.intervals)
                .withSuspect(m.suspect)
                .withThresholded(m.thresholded)
                .withTimeCollected(m.timeCollected)
                .withUpdate(m.update)
                .withAddressParityErrors(m.addressParityErrors)
                .withAddressParityErrorsCorrectable(m.addressParityErrorsCorrectable)
                .withAddressParityErrorsUnCorrectable(m.addressParityErrorsUnCorrectable)
                .withMismatchErrors(m.mismatchErrors)
                .withEccSinglebitErrors(m.eccSinglebitErrors)
                .withEccMultibitErrors(m.eccMultibitErrors)
                .withDramWriteDataCorrectableCRCErrors(m.DramWriteDataCorrectableCRCErrors)
                .withDramWriteDataUnCorrectableCRCErrors(m.DramWriteDataUnCorrectableCRCErrors)
                .build();
    }

    private UcsProcessorErrorStats from(ProcessorErrorStats p) {
        return UcsProcessorErrorStats.builder()
                .withDn(p.dn)
                .withIntervals(p.intervals)
                .withSuspect(p.suspect)
                .withThresholded(p.thresholded)
                .withTimeCollected(p.timeCollected)
                .withUpdate(p.update)
                .withCorrectableLinkCRCErrors(p.CorrectableLinkCRCErrors)
                .withUncorrectableLinkCRCErrors(p.UncorrectableLinkCRCErrors)
                .withMirroringInterSockErrors(p.mirroringInterSockErrors)
                .withMirroringIntraSockErrors(p.mirroringIntraSockErrors)
                .withSmiLinkCorrErrors(p.smiLinkCorrErrors)
                .withSmiLinkUncorrErrors(p.smiLinkUncorrErrors)
                .withSparingErrors(p.sparingErrors)
                .build();
    }

    private UcsComputePCIeFatalProtocolStats from(ComputePCIeFatalProtocolStats c) {
        return UcsComputePCIeFatalProtocolStats.builder()
                .withDn(c.dn)
                .withIntervals(c.intervals)
                .withSuspect(c.suspect)
                .withThresholded(c.thresholded)
                .withTimeCollected(c.timeCollected)
                .withUpdate(c.update)
                .withDllpErrors(c.dllpErrors)
                .withFlowControlErrors(c.flowControlErrors)
                .build();
    }

    private UcsComputePCIeFatalStats from(ComputePCIeFatalStats c) {
        return UcsComputePCIeFatalStats.builder()
                .withDn(c.dn)
                .withIntervals(c.intervals)
                .withSuspect(c.suspect)
                .withThresholded(c.thresholded)
                .withTimeCollected(c.timeCollected)
                .withUpdate(c.update)
                .withAcsViolationErrors(c.acsViolationErrors)
                .withMalformedTLPErrors(c.malformedTLPErrors)
                .withPoisonedTLPErrors(c.poisonedTLPErrors)
                .withSurpriseLinkDownErrors(c.surpriseLinkDownErrors)
                .build();
    }

    private UcsComputePCIeFatalReceiveStats from(ComputePCIeFatalReceiveStats c) {
        return UcsComputePCIeFatalReceiveStats.builder()
                .withDn(c.dn)
                .withIntervals(c.intervals)
                .withSuspect(c.suspect)
                .withThresholded(c.thresholded)
                .withTimeCollected(c.timeCollected)
                .withUpdate(c.update)
                .withBufferOverflowErrors(c.bufferOverflowErrors)
                .withErrFatalErrors(c.errFatalErrors)
                .withErrNonFatalErrors(c.errNonFatalErrors)
                .withUnsupportedRequestErrors(c.unsupportedRequestErrors)
                .build();
    }

    private UcsComputePCIeFatalCompletionStats from(ComputePCIeFatalCompletionStats c) {
        return UcsComputePCIeFatalCompletionStats.builder()
                .withDn(c.dn)
                .withIntervals(c.intervals)
                .withSuspect(c.suspect)
                .withThresholded(c.thresholded)
                .withTimeCollected(c.timeCollected)
                .withUpdate(c.update)
                .withUnexpectedErrors(c.unexpectedErrors)
                .withAbortErrors(c.AbortErrors)
                .withTimeoutErrors(c.TimeoutErrors)
                .build();
    }

    private UcsStorageSsdHealthStats from(StorageSsdHealthStats e) {
        return UcsStorageSsdHealthStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withId(e.id)
                .withPercentageLifeLeft(e.percentageLifeLeft)
                .withPowerCycleCount(e.powerCycleCount)
                .withPowerOnHours(e.powerOnHours)
                .withWearStatusInDays(e.wearStatusInDays)
                .build();
    }

    private UcsStorageDiskEnvStats from(StorageDiskEnvStats e) {
        return UcsStorageDiskEnvStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withTemperature(e.temperature)
                .withWearPercentage(e.wearPercentage)
                .build();
    }

    private UcsAdaptorVnicStats from(AdaptorVnicStats e) {
        return UcsAdaptorVnicStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withBytesRx(e.bytesRx)
                .withBytesTx(e.bytesTx)
                .withDroppedRx(e.droppedRx)
                .withDroppedTx(e.droppedTx)
                .withErrorsRx(e.errorsRx)
                .withErrorsTx(e.errorsTx)
                .withPacketsRx(e.packetsRx)
                .withPacketsTx(e.packetsTx)
                .build();
    }

    private UcsAdaptorEthPortStats from(AdaptorEthPortStats e) {
        return UcsAdaptorEthPortStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withGoodPackets(e.goodPackets)
                .withPausePackets(e.pausePackets)
                .withPppPackets(e.pppPackets)
                .withPerPriorityPausePackets(e.perPriorityPausePackets)
                .withTotalPackets(e.totalPackets)
                .withVlanPackets(e.vlanPackets)
                .withTrafficDirection(e.trafficDirection)
                .build();

    }

    private UcsAdaptorEthPortMcastStats from(AdaptorEthPortMcastStats e) {
        return UcsAdaptorEthPortMcastStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withBroadcastPackets(e.broadcastPackets)
                .withMulticastPackets(e.multicastPackets)
                .withUnicastPackets(e.unicastPacketsDelta)
                .withTrafficDirection(e.trafficDirection)
                .build();
    }

    private UcsAdaptorEthPortErrStats from(AdaptorEthPortErrStats e) {
        return UcsAdaptorEthPortErrStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withBadCrcPackets(e.badCrcPackets)
                .withBadLengthPackets(e.badLengthPackets)
                .withMacDiscardedPackets(e.macDiscardedPackets)
                .withTrafficDirection(e.trafficDirection)
                .build();
    }

    private UcsEquipmentFanStats from(EquipmentFanStats e) {
        return UcsEquipmentFanStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withSpeed(e.speed)
                .build();
    }

    private UcsEquipmentFanModuleStats from(EquipmentFanModuleStats e) {
        return UcsEquipmentFanModuleStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withAmbientTemp(e.ambientTemp)
                .withFanModuleI2CErrors(e.FanModuleI2CErrors)
                .build();
    }

    private UcsEtherNiErrStats from(EtherNiErrStats e) {
        return UcsEtherNiErrStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withFrameTx(e.frameTx)
                .withCrc(e.crc)
                .withInRange(e.inRange)
                .withTooLong(e.tooLong)
                .withTooShort(e.tooShort)
                .build();
    }

    private UcsEtherPauseStats from(EtherPauseStats e) {
        return UcsEtherPauseStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withRecvPause(e.recvPause)
                .withResets(e.resets)
                .withXmitPause(e.xmitPause)
                .build();
    }

    private UcsEtherLossStats from(EtherLossStats e) {
        return UcsEtherLossStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withCarrierSense(e.carrierSense)
                .withGiants(e.giants)
                .withExcessCollision(e.excessCollision)
                .withLateCollision(e.lateCollision)
                .withMultiCollision(e.multiCollision)
                .withSymbol(e.symbol)
                .withSingleCollision(e.singleCollision)
                .withSQETest(e.SQETest)
                .build();
    }

    private UcsEtherErrStats from(EtherErrStats e) {
        return UcsEtherErrStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withDeferredTx(e.deferredTx)
                .withAlign(e.align)
                .withFcs(e.fcs)
                .withiIntMacRx(e.intMacRx)
                .withIntMacTx(e.intMacTx)
                .withOutDiscard(e.outDiscard)
                .withRcv(e.rcv)
                .withUnderSize(e.underSize)
                .withXmit(e.xmit)
                .build();
    }

    private UcsEquipmentIOCardStats from(EquipmentIOCardStats e) {
        return UcsEquipmentIOCardStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withAmbientTemp(e.ambientTemp)
                .withTemp(e.temp)
                .withIomI2CErrors(e.IomI2CErrors)
                .build();
    }

    private UcsEquipmentPsuStats from(EquipmentPsuStats e) {
        return UcsEquipmentPsuStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withAmbientTemp(e.ambientTemp)
                .withInput210v(e.input210v)
                .withOutput12v(e.output12v)
                .withOutput3v3(e.output3v3)
                .withOutputCurrent(e.outputCurrent)
                .withOutputPower(e.outputPower)
                .withPsuI2CErrors(e.PsuI2CErrors)
                .build();
    }

    private UcsEquipmentPsuInputStats from(EquipmentPsuInputStats e) {
         return UcsEquipmentPsuInputStats.builder()
                 .withDn(e.dn)
                 .withIntervals(e.intervals)
                 .withSuspect(e.suspect)
                 .withThresholded(e.thresholded)
                 .withTimeCollected(e.timeCollected)
                 .withUpdate(e.update)
                 .withPower(e.power)
                 .withCurrent(e.current)
                 .withVoltage(e.voltage)
                 .withInputStatus(e.inputStatus)
                 .build();
    }

    private UcsEtherTxStats from(EtherTxStats e) {
        return UcsEtherTxStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withBroadcastPackets(e.broadcastPackets)
                .withJumboPackets(e.jumboPackets)
                .withMulticastPackets(e.multicastPackets)
                .withTotalBytes(e.totalBytes)
                .withTotalPackets(e.totalPackets)
                .withUnicastPackets(e.unicastPackets)
                .build();
    }

    private UcsEtherRxStats from(EtherRxStats e) {
        return UcsEtherRxStats.builder()
                .withDn(e.dn)
                .withIntervals(e.intervals)
                .withSuspect(e.suspect)
                .withThresholded(e.thresholded)
                .withTimeCollected(e.timeCollected)
                .withUpdate(e.update)
                .withBroadcastPackets(e.broadcastPackets)
                .withJumboPackets(e.jumboPackets)
                .withMulticastPackets(e.multicastPackets)
                .withTotalBytes(e.totalBytes)
                .withTotalPackets(e.totalPackets)
                .withUnicastPackets(e.unicastPackets)
                .build();
    }

    private UcsFcErrStats from(FcErrStats f) {
        return UcsFcErrStats.builder()
                .withDn(f.dn)
                .withIntervals(f.intervals)
                .withSuspect(f.suspect)
                .withThresholded(f.thresholded)
                .withTimeCollected(f.timeCollected)
                .withUpdate(f.update)
                .withCrcRx(f.crcRx)
                .withDiscardRx(f.discardRx)
                .withDiscardTx(f.discardTx)
                .withLinkFailures(f.linkFailures)
                .withRx(f.rx)
                .withSignalLosses(f.signalLosses)
                .withSyncLosses(f.syncLosses)
                .withTooLongRx(f.tooLongRx)
                .withTooShortRx(f.tooShortRx)
                .withTx(f.tx)
                .build();
    }

    private UcsFcStats from(FcStats fcStats) {
        return UcsFcStats.builder()
                .withDn(fcStats.dn)
                .withIntervals(fcStats.intervals)
                .withSuspect(fcStats.suspect)
                .withThresholded(fcStats.thresholded)
                .withTimeCollected(fcStats.timeCollected)
                .withUpdate(fcStats.update)
                .withBytesRx(fcStats.bytesRx)
                .withBytesTx(fcStats.bytesTx)
                .withPacketsRx(fcStats.packetsRx)
                .withPacketsTx(fcStats.packetsTx)
                .build();
    }

    private UcsEquipmentNetworkElementFanStats from(EquipmentNetworkElementFanStats equipmentNetworkElementFanStats) {
        return UcsEquipmentNetworkElementFanStats.builder()
                .withDn(equipmentNetworkElementFanStats.dn)
                .withIntervals(equipmentNetworkElementFanStats.intervals)
                .withSuspect(equipmentNetworkElementFanStats.suspect)
                .withThresholded(equipmentNetworkElementFanStats.thresholded)
                .withTimeCollected(equipmentNetworkElementFanStats.timeCollected)
                .withUpdate(equipmentNetworkElementFanStats.update)
                .withairflowDirection(equipmentNetworkElementFanStats.airflowDirection)
                .withSpeed(equipmentNetworkElementFanStats.speed)
                .withDrivePercentage(equipmentNetworkElementFanStats.drivePercentage)
                .build();
    }

    private UcsSwCardEnvStats from(SwCardEnvStats swCardEnvStats) {
        return UcsSwCardEnvStats.builder()
                .withDn(swCardEnvStats.dn)
                .withIntervals(swCardEnvStats.intervals)
                .withSuspect(swCardEnvStats.suspect)
                .withThresholded(swCardEnvStats.thresholded)
                .withTimeCollected(swCardEnvStats.timeCollected)
                .withUpdate(swCardEnvStats.update)
                .build();
    }

    private UcsSwSystemStats from(SwSystemStats swSystemStats) {
        return UcsSwSystemStats.builder()
                .withDn(swSystemStats.dn)
                .withIntervals(swSystemStats.intervals)
                .withSuspect(swSystemStats.suspect)
                .withThresholded(swSystemStats.thresholded)
                .withTimeCollected(swSystemStats.timeCollected)
                .withUpdate(swSystemStats.update)
                .withLoad(swSystemStats.load)
                .withMemAvailable(swSystemStats.memAvailable)
                .withMemCached(swSystemStats.memCached)
                .build();
    }

    private UcsSwEnvStats from(SwEnvStats swEnvStats) {
        return UcsSwEnvStats.builder()
                .withDn(swEnvStats.dn)
                .withIntervals(swEnvStats.intervals)
                .withSuspect(swEnvStats.suspect)
                .withThresholded(swEnvStats.thresholded)
                .withTimeCollected(swEnvStats.timeCollected)
                .withUpdate(swEnvStats.update)
                .withMainBoardOutlet1(swEnvStats.mainBoardOutlet1)
                .withMainBoardOutlet2(swEnvStats.mainBoardOutlet2)
                .build();
    }

    private UcsEquipmentChassisStats from(EquipmentChassisStats equipmentChassisStats) {
        return UcsEquipmentChassisStats.builder()
                .withDn(equipmentChassisStats.dn)
                .withIntervals(equipmentChassisStats.intervals)
                .withSuspect(equipmentChassisStats.suspect)
                .withThresholded(equipmentChassisStats.thresholded)
                .withTimeCollected(equipmentChassisStats.timeCollected)
                .withUpdate(equipmentChassisStats.update)
                .withChassisI2CErrors(equipmentChassisStats.ChassisI2CErrors)
                .withInputPower(equipmentChassisStats.inputPower)
                .withOutputPower(equipmentChassisStats.outputPower)
                .build();
    }

    private UcsComputeMbTempStats from(ComputeMbTempStats computeMbTempStats) {
        return UcsComputeMbTempStats.builder()
                .withDn(computeMbTempStats.dn)
                .withIntervals(computeMbTempStats.intervals)
                .withSuspect(computeMbTempStats.suspect)
                .withThresholded(computeMbTempStats.thresholded)
                .withTimeCollected(computeMbTempStats.timeCollected)
                .withUpdate(computeMbTempStats.update)
                .withFmTempSenIo(computeMbTempStats.fmTempSenIo)
                .withFmTempSenRear(computeMbTempStats.fmTempSenRear)
                .build();
    }

    private UcsComputeMbPowerStats from(ComputeMbPowerStats computeMbPowerStats) {
        return UcsComputeMbPowerStats.builder()
                .withDn(computeMbPowerStats.dn)
                .withIntervals(computeMbPowerStats.intervals)
                .withSuspect(computeMbPowerStats.suspect)
                .withThresholded(computeMbPowerStats.thresholded)
                .withTimeCollected(computeMbPowerStats.timeCollected)
                .withUpdate(computeMbPowerStats.update)
                .withConsumedPower(computeMbPowerStats.consumedPower)
                .withInputCurrent(computeMbPowerStats.inputCurrent)
                .withInputVoltage(computeMbPowerStats.inputVoltage)
                .build();
    }

    private UcsProcessorEnvStats from(ProcessorEnvStats processorEnvStats) {
        return UcsProcessorEnvStats.builder()
                .withDn(processorEnvStats.dn)
                .withIntervals(processorEnvStats.intervals)
                .withSuspect(processorEnvStats.suspect)
                .withThresholded(processorEnvStats.thresholded)
                .withTimeCollected(processorEnvStats.timeCollected)
                .withUpdate(processorEnvStats.update)
                .withTemperature(processorEnvStats.temperature)
                .build();
    }

    private static UcsFault from(FaultInst faultInst) {
        return UcsFault.builder()
                .withAck(faultInst.ack)
                .withCause(faultInst.cause)
                .withChangeSet(faultInst.changeSet)
                .withCode(faultInst.code)
                .withCreated(faultInst.created)
                .withDescr(faultInst.descr)
                .withDn(faultInst.dn)
                .withHighestSeverity(UcsFault.Severity.valueOf(faultInst.highestSeverity))
                .withId(faultInst.id)
                .withLastTransition(faultInst.lastTransition)
                .withLc(faultInst.lc)
                .withPrevSeverity(UcsFault.Severity.valueOf(faultInst.prevSeverity))
                .withOccur(faultInst.occur)
                .withOrigSeverity(UcsFault.Severity.valueOf(faultInst.origSeverity))
                .withSeverity(UcsFault.Severity.valueOf(faultInst.severity))
                .withRule(faultInst.rule)
                .withTags(faultInst.tags)
                .withType(UcsFault.Type.valueOf(faultInst.type))
                .build();
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
