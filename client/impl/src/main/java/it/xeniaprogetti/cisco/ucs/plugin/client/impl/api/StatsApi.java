package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortMcastStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorEthPortStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseAdaptorVnicStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseEquipmentNetworkElementFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseSwSystemStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortErrStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortMcastStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorEthPortStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.AdaptorVnicStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.EquipmentNetworkElementFanStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwCardEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwEnvStats;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.stats.SwSystemStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class StatsApi {
    private final Logger LOG = LoggerFactory.getLogger(StatsApi.class);
    private final ApiClient client;

    public StatsApi(ApiClient client) {
        this.client = client;
    }

    public List<AdaptorEthPortErrStats> getAdaptorEthPortErrStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortErrStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortErrStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortErrStats),
                ConfigResolveClassResponseAdaptorEthPortErrStats.class).adaptorEthPortErrStats;
    }

    public List<AdaptorEthPortMcastStats> getAdaptorEthPortMcastStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortMcastStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortMcastStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortMcastStats),
                ConfigResolveClassResponseAdaptorEthPortMcastStats.class).adaptorEthPortMcastStats;
    }

    public List<AdaptorEthPortStats> getAdaptorEthPortStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorEthPortStats: {} {}", filter, UcsEnums.NamingClassId.adaptorEthPortStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorEthPortStats),
                ConfigResolveClassResponseAdaptorEthPortStats.class).adaptorEthPortStats;
    }

    public List<AdaptorVnicStats> getAdaptorVnicStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getAdaptorVnicStats: {} {}", filter, UcsEnums.NamingClassId.adaptorVnicStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.adaptorVnicStats),
                ConfigResolveClassResponseAdaptorVnicStats.class).adaptorVnicStats;
    }

    public List<EquipmentNetworkElementFanStats> getEquipmentNetworkElementFanStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getEquipmentNetworkElementFanStats: {} {}", filter, UcsEnums.NamingClassId.equipmentNetworkElementFanStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.equipmentNetworkElementFanStats),
                ConfigResolveClassResponseEquipmentNetworkElementFanStats.class).equipmentNetworkElementFanStats;
    }

    public List<SwEnvStats> getSwEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getUcsSwEnvStats: {} {}", filter, UcsEnums.NamingClassId.swEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swEnvStats),
                ConfigResolveClassResponseSwEnvStats.class).swEnvStats;
    }

    public List<SwCardEnvStats> getSwCardEnvStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getSwCardEnvStats: {} {}", filter, UcsEnums.NamingClassId.swCardEnvStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swCardEnvStats),
                ConfigResolveClassResponseSwCardEnvStats.class).swCardEnvStats;
    }

    public List<SwSystemStats> getSwSystemStats(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getSwEnvStats: {} {}", filter, UcsEnums.NamingClassId.swSystemStats);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.swSystemStats),
                ConfigResolveClassResponseSwSystemStats.class).swSystemStats;
    }


}
