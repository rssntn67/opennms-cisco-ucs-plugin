package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortMcastStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorVnicStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputeMbPowerStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputeMbTempStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputePCIeFatalCompletionStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputePCIeFatalProtocolStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputePCIeFatalReceiveStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputePCIeFatalStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentChassisStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentFanModuleStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentIOCardStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentNetworkElementFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentPsuInputStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentPsuStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherLossStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherNiErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherPauseStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherRxStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEtherTxStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseFcErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseFcStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseMemoryErrorStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseMemoryUnitEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseProcessorEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseProcessorErrorStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseStorageDiskEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseStorageSsdHealthStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwSystemStats;
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

import java.util.List;
import java.util.Objects;

public class StatsApi {
    private final Logger LOG = LoggerFactory.getLogger(StatsApi.class);
    private final ApiClient client;
    private final String url;

    public StatsApi(ApiClient client, String url) {
        this.client = Objects.requireNonNull(client);
        this.url = Objects.requireNonNull(url);
    }

    public List<AdaptorEthPortErrStats> getAdaptorEthPortErrStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortErrStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortErrStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortErrStats),
                this.url,
                ConfigResolveClassResponseAdaptorEthPortErrStats.class).stats;
    }

    public List<AdaptorEthPortMcastStats> getAdaptorEthPortMcastStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortMcastStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortMcastStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortMcastStats),
                this.url,
                ConfigResolveClassResponseAdaptorEthPortMcastStats.class).stats;
    }

    public List<AdaptorEthPortStats> getAdaptorEthPortStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortStats),
                this.url,
                ConfigResolveClassResponseAdaptorEthPortStats.class).stats;
    }

    public List<AdaptorVnicStats> getAdaptorVnicStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorVnicStats: {} {}", filter, UcsEnums.NamingClassId.adaptorVnicStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorVnicStats),
                this.url,
                ConfigResolveClassResponseAdaptorVnicStats.class).stats;
    }

    public List<ComputeMbPowerStats> getComputeMbPowerStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getComputeMbPowerStats: {} {}", filter, UcsEnums.NamingClassId.computeMbPowerStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                                cookie,
                                filter,UcsEnums.NamingClassId.computeMbPowerStats
                ),
                this.url,
                ConfigResolveClassResponseComputeMbPowerStats.class)
                .stats;
    }

    public List<ComputeMbTempStats> getComputeMbTempStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getComputeMbTempStats: {} {}", filter, UcsEnums.NamingClassId.computeMbTempStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.computeMbTempStats
                ),
                this.url,
                ConfigResolveClassResponseComputeMbTempStats.class)
                .stats;
    }

    public List<ComputePCIeFatalCompletionStats> getComputePCIeFatalCompletionStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getPCIeFatalCompletionStats: {} {}", filter, UcsEnums.NamingClassId.computePCIeFatalCompletionStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.computePCIeFatalCompletionStats
                ),
                this.url,
                ConfigResolveClassResponseComputePCIeFatalCompletionStats.class)
                .stats;
    }

    public List<ComputePCIeFatalProtocolStats> getComputePCIeFatalProtocolStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getPCIeFatalProtocolStats: {} {}", filter, UcsEnums.NamingClassId.computePCIeFatalProtocolStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.computePCIeFatalProtocolStats
                ),
                this.url,
                ConfigResolveClassResponseComputePCIeFatalProtocolStats.class)
                .stats;
    }

    public List<ComputePCIeFatalReceiveStats> getComputePCIeFatalReceiveStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getPCIeFatalReceiveStats: {} {}", filter, UcsEnums.NamingClassId.computePCIeFatalReceiveStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.computePCIeFatalReceiveStats
                ),
                this.url,
                ConfigResolveClassResponseComputePCIeFatalReceiveStats.class)
                .stats;
    }

    public List<ComputePCIeFatalStats> getPCIeFatalStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getPCIeFatalStats: {} {}", filter, UcsEnums.NamingClassId.computePCIeFatalStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.computePCIeFatalStats
                ),
                this.url,
                ConfigResolveClassResponseComputePCIeFatalStats.class)
                .stats;
    }

    public List<EquipmentChassisStats> getEquipmentChassisStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentChassisStats: {} {}", filter, UcsEnums.NamingClassId.equipmentChassisStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentChassisStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentChassisStats.class)
                .stats;
    }

    public List<EquipmentFanModuleStats> getEquipmentFanModuleStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentFanModuleStats: {} {}", filter, UcsEnums.NamingClassId.equipmentFanModuleStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentFanModuleStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentFanModuleStats.class)
                .stats;
    }

    public List<EquipmentFanStats> getEquipmentFanStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentFanStats: {} {}", filter, UcsEnums.NamingClassId.equipmentFanStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentFanStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentFanStats.class)
                .stats;
    }

    public List<EquipmentIOCardStats> getEquipmentIOCardStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentIOCardStats: {} {}", filter, UcsEnums.NamingClassId.equipmentIOCardStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentIOCardStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentIOCardStats.class)
                .stats;
    }

    public List<EquipmentNetworkElementFanStats> getEquipmentNetworkElementFanStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentNetworkElementFanStats: {} {}", filter, UcsEnums.NamingClassId.equipmentNetworkElementFanStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentNetworkElementFanStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentNetworkElementFanStats.class)
                .stats;
    }

    public List<EquipmentPsuInputStats> getEquipmentPsuInputStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentPsuInputStats: {} {}", filter, UcsEnums.NamingClassId.equipmentPsuInputStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentPsuInputStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentPsuInputStats.class)
                .stats;
    }

    public List<EquipmentPsuStats> getEquipmentPsuStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentPsuStats: {} {}", filter, UcsEnums.NamingClassId.equipmentPsuStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.equipmentPsuStats
                ),
                this.url,
                ConfigResolveClassResponseEquipmentPsuStats.class)
                .stats;
    }

    public List<EtherErrStats> getEtherErrStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherErrStats: {} {}", filter, UcsEnums.NamingClassId.etherErrStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherErrStats
                ),
                this.url,
                ConfigResolveClassResponseEtherErrStats.class)
                .stats;
    }

    public List<EtherLossStats> getEtherLossStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherLossStats: {} {}", filter, UcsEnums.NamingClassId.etherLossStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherLossStats
                ),
                this.url,
                ConfigResolveClassResponseEtherLossStats.class)
                .stats;
    }

    public List<EtherNiErrStats> getEtherNiErrStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherNiErrStats: {} {}", filter, UcsEnums.NamingClassId.etherNiErrStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherNiErrStats
                ),
                this.url,
                ConfigResolveClassResponseEtherNiErrStats.class)
                .stats;
    }

    public List<EtherPauseStats> getEtherPauseStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherPauseStats: {} {}", filter, UcsEnums.NamingClassId.etherPauseStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherPauseStats
                ),
                this.url,
                ConfigResolveClassResponseEtherPauseStats.class)
                .stats;
    }

    public List<EtherRxStats> getEtherRxStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherRxStats: {} {}", filter, UcsEnums.NamingClassId.etherRxStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherRxStats
                ),
                this.url,
                ConfigResolveClassResponseEtherRxStats.class)
                .stats;
    }

    public List<EtherTxStats> getEtherTxStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEtherTxStats: {} {}", filter, UcsEnums.NamingClassId.etherTxStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.etherTxStats
                ),
                this.url,
                ConfigResolveClassResponseEtherTxStats.class)
                .stats;
    }

    public List<FcErrStats> getFcErrStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getFcErrStats: {} {}", filter, UcsEnums.NamingClassId.fcErrStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.fcErrStats
                ),
                this.url,
                ConfigResolveClassResponseFcErrStats.class)
                .stats;
    }

    public List<FcStats> getFcStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getFcStats: {} {}", filter, UcsEnums.NamingClassId.fcStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.fcStats
                ),
                this.url,
                ConfigResolveClassResponseFcStats.class)
                .stats;
    }

    public List<MemoryErrorStats> getMemoryErrorStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getMemoryErrorStats: {} {}", filter, UcsEnums.NamingClassId.memoryErrorStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.memoryErrorStats
                ),
                this.url,
                ConfigResolveClassResponseMemoryErrorStats.class)
                .stats;
    }

    public List<MemoryUnitEnvStats> getMemoryUnitEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getMemoryUnitEnvStats: {} {}", filter, UcsEnums.NamingClassId.memoryUnitEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.memoryUnitEnvStats
                ),
                this.url,
                ConfigResolveClassResponseMemoryUnitEnvStats.class)
                .stats;
    }

    public List<ProcessorEnvStats> getProcessorEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getProcessorEnvStats: {} {}", filter, UcsEnums.NamingClassId.processorEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.processorEnvStats
                ),
                this.url,
                ConfigResolveClassResponseProcessorEnvStats.class)
                .stats;
    }

    public List<ProcessorErrorStats> getProcessorErrorStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getProcessorErrorStats: {} {}", filter, UcsEnums.NamingClassId.processorErrorStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.processorErrorStats
                ),                 this.url,
                ConfigResolveClassResponseProcessorErrorStats.class)
                .stats;
    }

    public List<StorageDiskEnvStats> getStorageDiskEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getStorageDiskEnvStats: {} {}", filter, UcsEnums.NamingClassId.storageDiskEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.storageDiskEnvStats
                ),
                this.url,
                ConfigResolveClassResponseStorageDiskEnvStats.class)
                .stats;
    }

    public List<StorageSsdHealthStats> getStorageSsdHealthStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getStorageSsdHealthStats: {} {}", filter, UcsEnums.NamingClassId.storageSsdHealthStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(
                        cookie,
                        filter,UcsEnums.NamingClassId.storageSsdHealthStats
                ),                this.url,
                ConfigResolveClassResponseStorageSsdHealthStats.class)
                .stats;
    }

    public List<SwEnvStats> getSwEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getUcsSwEnvStats: {} {}", filter, UcsEnums.NamingClassId.swEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swEnvStats),
                this.url,
                ConfigResolveClassResponseSwEnvStats.class).stats;
    }

    public List<SwCardEnvStats> getSwCardEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getSwCardEnvStats: {} {}", filter, UcsEnums.NamingClassId.swCardEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swCardEnvStats),
                this.url,
                ConfigResolveClassResponseSwCardEnvStats.class).stats;
    }

    public List<SwSystemStats> getSwSystemStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getSwEnvStats: {} {}", filter, UcsEnums.NamingClassId.swSystemStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swSystemStats),
                this.url,
                ConfigResolveClassResponseSwSystemStats.class).stats;
    }


}
