package it.xeniaprogetti.cisco.ucs.plugin.client;

public interface ApiClientProvider {
    /**
     * Create a client for a Cisco UCS Manager XML Api .
     *
     * @param credentials the credentials to use for the client.
     * @return a NutanixApiClient client
     */
    ApiClientService client(final ApiClientCredentials credentials);

    boolean validate(final ApiClientCredentials credentials);

}
