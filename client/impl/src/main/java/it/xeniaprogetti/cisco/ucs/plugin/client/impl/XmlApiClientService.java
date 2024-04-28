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

import java.util.List;

public class XmlApiClientService implements ApiClientService {

    private final ApiClient client;
    private final ApiClientCredentials credentials;
    private final AaaApi aaaApi;
    private final ConfigApi configApi;


    public XmlApiClientService(ApiClientCredentials credentials) {
        this.client = XmlApiClientprovider.getApiClient(credentials);
        this.credentials = credentials;
        this.aaaApi = new AaaApi(credentials, client);
        this.configApi = new ConfigApi(client);
    }


    @Override
    public UcsComputeBlade resolveUcsComputeBladeByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public UcsComputeRackUnit resolveUcsComputeRackUnitByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public UcsEquipmentChassis resolveUcsEquipmentChassisByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public UcsEquipmentFex resolveUcsEquipmentFexByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public UcsNetworkElement resolveUcsNetworkElementByDn(String dn) throws ApiException {
        return null;
    }

    @Override
    public List<UcsComputeBlade> getUcsComputeBladeList(String dn) throws ApiException {
        return List.of();
    }

    @Override
    public List<UcsComputeRackUnit> getUcsComputeRackUnitList(String dn) throws ApiException {
        return List.of();
    }

    @Override
    public List<UcsEquipmentChassis> getUcsEquipmentChassisList(String dn) throws ApiException {
        return List.of();
    }

    @Override
    public List<UcsEquipmentFex> getUcsEquipmentFexList(String dn) throws ApiException {
        return List.of();
    }

    @Override
    public List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList(String dn) throws ApiException {
        return List.of();
    }

    @Override
    public List<UcsNetworkElement> getUcsNetworkElementList(String dn) throws ApiException {
        return List.of();
    }
}
