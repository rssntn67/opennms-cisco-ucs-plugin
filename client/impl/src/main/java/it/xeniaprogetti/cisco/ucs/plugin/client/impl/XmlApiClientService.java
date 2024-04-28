package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.AaaApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.api.ConfigApi;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.handler.ApiClient;
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
    public UcsComputeBlade resolveUcsComputeBladeByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsComputeBladeByDn(aaaApi.getToken(), dn));
    }

    @Override
    public UcsComputeRackUnit resolveUcsComputeRackUnitByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsComputeRackUnitByDn(aaaApi.getToken(), dn));
    }

    @Override
    public UcsEquipmentChassis resolveUcsEquipmentChassisByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsEquipmentChassisByDn(aaaApi.getToken(), dn));
    }

    @Override
    public UcsEquipmentFex resolveUcsEquipmentFexByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsEquipmentFexByDn(aaaApi.getToken(), dn));
    }

    @Override
    public UcsEquipmentRackEnclosure resolveUcsEquipmentRackEnclosureByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsEquipmentRackEnclosureByDn(aaaApi.getToken(), dn));
    }

    @Override
    public UcsNetworkElement resolveUcsNetworkElementByDn(String dn) throws ApiException {
        checkCredentials();
        return from(configApi.getUcsNetworkElementByDn(aaaApi.getToken(), dn));
    }

    @Override
    public List<UcsComputeBlade> getUcsComputeBladeList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsComputeBladeListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsComputeRackUnit> getUcsComputeRackUnitList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsComputeRackUnitListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentChassis> getUcsEquipmentChassisList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentChassisListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentFex> getUcsEquipmentFexList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentFexListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsEquipmentRackEnclosure> getUcsEquipmentRackEnclosureList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsEquipmentRackEnclosureListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<UcsNetworkElement> getUcsNetworkElementList(String dn) throws ApiException {
        checkCredentials();
        return configApi
                .getUcsNetworkElementListByClassId(aaaApi.getToken())
                .stream()
                .map(XmlApiClientService::from)
                .collect(Collectors.toList());
    }

    private static UcsComputeBlade from(ComputeBlade compute) {
        return UcsComputeBlade.builder()
                .withDn(compute.dn)
                .build();
    }

    private static UcsComputeRackUnit from(ComputeRackUnit compute) {
        return UcsComputeRackUnit.builder()
                .withDn(compute.dn)
                .build();
    }

    private static UcsEquipmentChassis from(EquipmentChassis equipment) {
        return UcsEquipmentChassis.builder()
                .withDn(equipment.dn)
                .build();
    }

    private static UcsEquipmentFex from(EquipmentFex equipment) {
        return UcsEquipmentFex.builder()
                .withDn(equipment.dn)
                .build();
    }

    private static UcsEquipmentRackEnclosure from(EquipmentRackEnclosure equipment) {
        return UcsEquipmentRackEnclosure.builder()
                .withDn(equipment.dn)
                .build();
    }

    private static UcsNetworkElement from(NetworkElement network) {
        return UcsNetworkElement.builder()
                .withDn(network.dn)
                .build();
    }


}
