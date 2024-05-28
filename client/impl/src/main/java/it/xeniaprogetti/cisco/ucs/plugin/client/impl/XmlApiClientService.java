package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsFault;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsIpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElementStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsProcessorEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsSwSystemStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.FaultApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.IpApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.StatsApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
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
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.ProcessorEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwSystemStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class XmlApiClientService implements ApiClientService {

    Logger LOG = LoggerFactory.getLogger(XmlApiClientService.class);
    private final ApiClientCredentials credentials;
    private final AaaApi aaaApi;
    private final ConfigApi configApi;
    private final IpApi ipApi;
    private final FaultApi faultApi;
    private final StatsApi statsApi;

    public XmlApiClientService(ApiClientCredentials credentials) {
        ApiClient client = XmlApiClientProvider.getApiClient(credentials);
        this.credentials = credentials;
        this.aaaApi = new AaaApi(credentials, client);
        this.configApi = new ConfigApi(client);
        this.ipApi = new IpApi(client);
        this.faultApi = new FaultApi(client);
        this.statsApi = new StatsApi(client);
    }


    protected void checkCredentials() throws ApiException {
        if (aaaApi.getToken() == null) {
            aaaApi.login();
            LOG.debug("checkCredentials: login! first");
        } else if (aaaApi.isValid() && !aaaApi.isValidTokenAtLeastFor(credentials.validity)) {
            aaaApi.refresh();
            LOG.debug("checkCredentials: refreshed token: previous token was valid for less then {} seconds", credentials.validity);
        } else if (!aaaApi.isValid()) {
            aaaApi.logout();
            LOG.debug("checkCredentials: logout! token is no more valid");
            aaaApi.login();
            LOG.debug("checkCredentials: new login!");
        }
        LOG.info("checkCredentials: token is valid for at least {} seconds", credentials.validity);
    }

    @Override
    public void disconnect() throws ApiException {
        aaaApi.logout();
    }

    @Override
    public String getUcsXmlFromDn(String dn, boolean isHierarchical) throws ApiException {
        checkCredentials();
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
    public List<String> findDnByClassItem(UcsEnums.NamingClassId classId) throws ApiException{
        checkCredentials();
        return configApi.getDnByClassId(aaaApi.getToken(), classId);
    }

    @Override
    public List<UcsIpPoolPooled> findUcsIpPoolPooled() throws ApiException {
        checkCredentials();
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
        checkCredentials();
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
        checkCredentials();
        return faultApi
                .getUcsFaultsByFilter(aaaApi.getToken(), filter)
                .stream()
                .map(XmlApiClientService::from)
                .filter(ucsFault ->
                        ucsFault.lastTransition.isAfter(from) && ucsFault.lastTransition.isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public UcsManager getUcsManager() throws ApiException {
        return UcsManager
                .builder()
                .witLabel(UcsUtils.getLabelFromCredentials(this.credentials))
                .withAddress(UcsUtils.getIpAddressFromCredentials(this.credentials)).
                build();
    }

    @Override
    public UcsNetworkElementStats getNetworkElementStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException {
        LOG.debug("getNetworkElementStats: {}", collectMap);
        checkCredentials();
        UcsSwEnvStats swEnvStats = null;
        UcsSwSystemStats swSystemStats = null;
        UcsSwCardEnvStats swCardEnvStats = null;
        for (String dn: collectMap.keySet()) {
            for (UcsEnums.NamingClassId classid: collectMap.get(dn)) {
                UcsXmlApiRequest.InFilter filter = UcsXmlApiRequest.getWCardFilter(
                        UcsEnums.NamingClassId.swEnvStats,
                        "dn",
                        dn+".*");
                switch (classid) {
                    case swEnvStats:
                        swEnvStats =  from(statsApi.getSwEnvStats(aaaApi.getToken(), filter ).get(0));
                        break;
                    case swSystemStats:
                        swSystemStats = from(statsApi.getSwSystemStats(aaaApi.getToken(), filter).get(0));
                        break;
                    case swCardEnvStats:
                        swCardEnvStats = from(statsApi.getSwCardEnvStats(aaaApi.getToken(), filter).get(0));
                    default:
                        break;

                }
            }
        }
        return UcsNetworkElementStats.builder()
                .withUcsSwEnvStats(swEnvStats)
                .withUcsSwSystemStats(swSystemStats)
                .withUcsSwCardEnvStats(swCardEnvStats)
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
                .withload(swSystemStats.load)
                .withloadAvg(swSystemStats.loadAvg)
                .withloadMax(swSystemStats.loadMax)
                .withloadMin(swSystemStats.loadMin)
                .withmemAvailable(swSystemStats.memAvailable)
                .withmemAvailableAvg(swSystemStats.memAvailableAvg)
                .withmemAvailableMax(swSystemStats.memAvailableMax)
                .withmemAvailableMin(swSystemStats.memAvailableMin)
                .withmemCached(swSystemStats.memCached)
                .withmemCachedAvg(swSystemStats.memCachedAvg)
                .withmemCachedMax(swSystemStats.memCachedMax)
                .withmemCachedMin(swSystemStats.memCachedMin)
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
                .withmainBoardOutlet1(swEnvStats.mainBoardOutlet1)
                .withmainBoardOutlet2(swEnvStats.mainBoardOutlet2)
                .withmainBoardOutlet1Avg(swEnvStats.mainBoardOutlet1Avg)
                .withmainBoardOutlet2Avg(swEnvStats.mainBoardOutlet2Avg)
                .withmainBoardOutlet1Max(swEnvStats.mainBoardOutlet1Max)
                .withmainBoardOutlet2Max(swEnvStats.mainBoardOutlet2Max)
                .withmainBoardOutlet1Min(swEnvStats.mainBoardOutlet1Min)
                .withmainBoardOutlet2Min(swEnvStats.mainBoardOutlet2Min)
                .build();
    }

    @Override
    public UcsEquipmentStats getUcsEquipmentStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException {
        LOG.debug("getUcsEquipmentStats: {}", collectMap);
        checkCredentials();
        UcsEquipmentChassisStats ucsEquipmentChassisStats = null;
        for (String dn: collectMap.keySet()) {
            for (UcsEnums.NamingClassId classId: collectMap.get(dn)) {
                if (classId == UcsEnums.NamingClassId.equipmentChassisStats) {
                    UcsXmlApiRequest.InFilter filter = UcsXmlApiRequest.getWCardFilter(
                            UcsEnums.NamingClassId.equipmentChassisStats,
                            "dn",
                            dn+".*");
                    ucsEquipmentChassisStats =  from(statsApi.getEquipmentChassisStats(aaaApi.getToken(), filter ).get(0));
                    LOG.debug("getUcsEquipmentStats: {}", ucsEquipmentChassisStats);
                }
            }
        }
        return UcsEquipmentStats.builder()
                .withUcsEquipmentChassisStats(ucsEquipmentChassisStats)
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
                .withChassisI2CErrorsAvg(equipmentChassisStats.ChassisI2CErrorsAvg)
                .withChassisI2CErrorsMax(equipmentChassisStats.ChassisI2CErrorsMax)
                .withChassisI2CErrorsMin(equipmentChassisStats.ChassisI2CErrorsMin)
                .withinputPower(equipmentChassisStats.inputPower)
                .withinputPowerAvg(equipmentChassisStats.inputPowerAvg)
                .withinputPowerMax(equipmentChassisStats.inputPowerMax)
                .withinputPowerMin(equipmentChassisStats.inputPowerMin)
                .withoutputPower(equipmentChassisStats.outputPower)
                .withoutputPowerAvg(equipmentChassisStats.outputPowerAvg)
                .withoutputPowerMax(equipmentChassisStats.outputPowerMax)
                .withoutputPowerMin(equipmentChassisStats.outputPowerMin)
                .build();
    }

    @Override
    public UcsComputeStats getUcsComputeStats(Map<String, Set<UcsEnums.NamingClassId>> collectMap) throws ApiException {
        LOG.debug("getUcsComputeStats: {}", collectMap);
        checkCredentials();
        final List<UcsProcessorEnvStats> ucsProcessorEnvStats = new ArrayList<>();
        UcsComputeMbTempStats ucsComputeMbTempStats = null;
        UcsComputeMbPowerStats ucsComputeMbPowerStats = null;
        for (String dn: collectMap.keySet()) {
            for (UcsEnums.NamingClassId classId: collectMap.get(dn)) {
                UcsXmlApiRequest.InFilter filter = UcsXmlApiRequest.getWCardFilter(
                        classId,
                        "dn",
                        dn+".*");
                switch (classId) {
                    case processorEnvStats:
                        statsApi.getProcessorEnvStats(aaaApi.getToken(), filter ).forEach(p -> ucsProcessorEnvStats.add(from(p)));
                        LOG.debug("getUcsComputeStats: getUcsComputeStats.size = {}", ucsProcessorEnvStats.size());
                        break;
                    case computeMbPowerStats:
                        ucsComputeMbPowerStats =  from(statsApi.getComputeMbPowerStats(aaaApi.getToken(), filter ).get(0));
                        LOG.debug("getUcsComputeStats: ucsComputeMbPowerStats {}", ucsComputeMbPowerStats);
                        break;
                    case computeMbTempStats:
                        ucsComputeMbTempStats =  from(statsApi.getComputeMbTempStats(aaaApi.getToken(), filter ).get(0));
                        LOG.debug("getUcsComputeStats: ucsComputeMbPowerStats {}", ucsComputeMbPowerStats);
                        break;

                    default:
                        break;
                }
            }
        }
        return UcsComputeStats.builder()
                .withUcsProcessorEnvStats(ucsProcessorEnvStats)
                .withUcsComputeMbPowerStats(ucsComputeMbPowerStats)
                .withUcsComputeTempStats(ucsComputeMbTempStats)
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
                .withfmTempSenIo(computeMbTempStats.fmTempSenIo)
                .withfmTempSenIoAvg(computeMbTempStats.fmTempSenIoAvg)
                .withfmTempSenIoMax(computeMbTempStats.fmTempSenIoMax)
                .withfmTempSenIoMin(computeMbTempStats.fmTempSenIoMin)
                .withfmTempSenRear(computeMbTempStats.fmTempSenRear)
                .withfmTempSenRearAvg(computeMbTempStats.fmTempSenRearAvg)
                .withfmTempSenRearMax(computeMbTempStats.fmTempSenRearMax)
                .withfmTempSenRearMin(computeMbTempStats.fmTempSenRearMin)
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
                .withconsumedPower(computeMbPowerStats.consumedPower)
                .withconsumedPowerAvg(computeMbPowerStats.consumedPowerAvg)
                .withconsumedPowerMax(computeMbPowerStats.consumedPowerMax)
                .withconsumedPowerMin(computeMbPowerStats.consumedPowerMin)
                .withinputCurrent(computeMbPowerStats.inputCurrent)
                .withinputCurrentAvg(computeMbPowerStats.inputCurrentAvg)
                .withinputCurrentMax(computeMbPowerStats.inputCurrentMax)
                .withinputCurrentMin(computeMbPowerStats.inputCurrentMin)
                .withinputVoltage(computeMbPowerStats.inputVoltage)
                .withinputVoltageAvg(computeMbPowerStats.inputVoltageAvg)
                .withinputVoltageMax(computeMbPowerStats.inputVoltageMax)
                .withinputVoltageMin(computeMbPowerStats.inputVoltageMin)
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
                .withtemperature(processorEnvStats.temperature)
                .withtemperatureMin(processorEnvStats.temperatureMin)
                .withtemperatureMax(processorEnvStats.temperatureMax)
                .withtemperatureAvg(processorEnvStats.temperatureAvg)
                .build();
    }

    private static UcsFault from(FaultInst faultInst) {
        return UcsFault.builder()
                .withAck(faultInst.ack)
                .withCause(faultInst.cause)
                .withChangeSet(faultInst.changeSet)
                .withCode(faultInst.code)
                .withCreated(faultInst.created.toInstant().atOffset(ZoneOffset.systemDefault().getRules().getOffset(LocalDateTime.now())))
                .withDescr(faultInst.descr)
                .withDn(faultInst.dn)
                .withHighestSeverity(UcsFault.Severity.valueOf(faultInst.highestSeverity))
                .withId(faultInst.id)
                .withLastTransition(faultInst.lastTransition.toInstant().atOffset(ZoneOffset.systemDefault().getRules().getOffset(LocalDateTime.now())))
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
