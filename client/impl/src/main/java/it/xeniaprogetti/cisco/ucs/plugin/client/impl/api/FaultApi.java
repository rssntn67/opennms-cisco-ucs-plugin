package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault.FaultInst;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseFaultInst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class FaultApi {
    private final Logger LOG = LoggerFactory.getLogger(ConfigApi.class);
    private final ApiClient client;
    private final String url;

    public FaultApi(ApiClient client, String url) {
        this.client = Objects.requireNonNull(client);
        this.url = Objects.requireNonNull(url);
    }

    public List<FaultInst> getUcsFaults(String cookie) throws ApiException {
        LOG.info("getUcsFaults: {}", UcsEnums.NamingClassId.faultInst);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEnums.NamingClassId.faultInst),
                this.url,
                ConfigResolveClassResponseFaultInst.class
        ).faultInsts;
    }

    public List<FaultInst> getUcsFaultsByFilter(String cookie, UcsXmlApiRequest.InFilter filter) throws ApiException {
        LOG.info("getUcsFaultsByFilter: {} {}", filter, UcsEnums.NamingClassId.faultInst);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie,filter,UcsEnums.NamingClassId.faultInst),
                this.url,
                ConfigResolveClassResponseFaultInst.class).faultInsts;
    }

}
