package it.xeniaprogetti.cisco.ucs.plugin.client;

import java.util.List;

public interface ApiClientService {

    public List<String> getComputeItems();

    public Object resolveDn(String dn);
}
