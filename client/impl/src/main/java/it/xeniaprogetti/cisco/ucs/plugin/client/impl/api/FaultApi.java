package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEntity;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.compute.ComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.fault.FaultInst;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseComputeBladeList;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveClassResponseFaultInstList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FaultApi {
    private final Logger LOG = LoggerFactory.getLogger(ConfigApi.class);
    private final ApiClient client;

    public FaultApi(ApiClient client) {
        this.client = client;
    }

    public List<FaultInst> getUcsFaults(String cookie) throws ApiException {
        LOG.info("getUcsFaults: {}", UcsEntity.ClassId.faultInst);
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveClassRequest(cookie, UcsEntity.ClassId.faultInst),
                ConfigResolveClassResponseFaultInstList.class
        ).faultInsts;
    }

}
