package it.xeniaprogetti.cisco.ucs.plugin.client.impl.api;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.ip.IpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPool;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.IpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.LsServer;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.org.root.VNicIpV4PooledAddr;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.request.UcsXmlApiRequest;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseIpPoolPool;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseIpPoolPooled;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseIpPoolUniverse;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseLsServer;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.model.response.ConfigResolveDnResponseVNicIpV4PooledAddr;

import java.util.Objects;

public class IpApi {

    private final ApiClient client;
    private final String url;

    public IpApi(ApiClient client, String url) {
        this.client = Objects.requireNonNull(client);
        this.url = Objects.requireNonNull(url);
    }

    public IpPoolUniverse getIpPoolUniverse(String cookie) throws ApiException {
        return client
                .getUcsXmlApiResponse(
                        UcsXmlApiRequest.getConfigResolveDnRequest(cookie,"ip",true),
                        this.url,
                        ConfigResolveDnResponseIpPoolUniverse.class
                ).outconfig.ippoolUniverse;
    }

    public VNicIpV4PooledAddr getVnicVNicIpV4PooledAddr(String cookie, String poolAssignedToDn) throws  ApiException {
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveDnRequest(cookie, poolAssignedToDn, false),
                this.url,
                ConfigResolveDnResponseVNicIpV4PooledAddr.class
        ).outconfig.vnicIpV4PooledAddr;
    }

    public IpPoolPooled getIpPoolPooled(String cookie, String poolDn) throws ApiException {
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveDnRequest(cookie, poolDn, false),
                this.url,
                ConfigResolveDnResponseIpPoolPooled.class
        ).outconfig.ippoolPooled;
    }

    public LsServer getLsServer(String cookie, String assignedToDn) throws ApiException {
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveDnRequest(cookie, assignedToDn, false),
                this.url,
                ConfigResolveDnResponseLsServer.class
        ).outconfig.lsServer;
    }

    public IpPoolPool getIpPoolPool(String cookie, String poolName) throws ApiException {
        return client.getUcsXmlApiResponse(
                UcsXmlApiRequest.getConfigResolveDnRequest(cookie, poolName,true),
                this.url,
                ConfigResolveDnResponseIpPoolPool.class
        ).outconfig.ippoolPool;
    }

}
