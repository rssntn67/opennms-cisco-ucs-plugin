package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;

public class XmlApiClientprovider implements ApiClientProvider {


    @Override
    public ApiClientService client(ApiClientCredentials credentials) {
        return new XmlApiClientService(credentials);
    }

    @Override
    public boolean validate(ApiClientCredentials credentials) {
        return false;
    }
}
