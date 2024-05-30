package it.xeniaprogetti.cisco.ucs.plugin;

import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.Aggregate;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDn;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDnComparator;
import it.xeniaprogetti.cisco.ucs.plugin.client.impl.XmlApiClientProvider;
import it.xeniaprogetti.cisco.ucs.plugin.connection.Connection;
import org.junit.Assert;
import org.junit.Test;
import org.opennms.integration.api.v1.collectors.CollectionSet;
import org.opennms.integration.api.v1.collectors.resource.NodeResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSet;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableCollectionSetResource;
import org.opennms.integration.api.v1.collectors.resource.immutables.ImmutableNodeResource;
import org.opennms.integration.api.v1.runtime.Container;
import org.opennms.integration.api.v1.runtime.RuntimeInfo;
import org.opennms.integration.api.v1.runtime.Version;
import org.opennms.integration.api.v1.scv.Credentials;
import org.opennms.integration.api.v1.scv.SecureCredentialsVault;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsServiceCollector.addAggregate;
import static it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsServiceCollector.addNumAttr;
import static it.xeniaprogetti.cisco.ucs.plugin.collection.AbstractUcsServiceCollector.createStringAttribute;

public class CiscoUcsPluginTest {

    @Test
    public void testUcsDnSorting() {

        UcsDn chassis3 = UcsDn.getDn("sys/chassis-3");
        UcsDn blade1 = UcsDn.getDn("sys/chassis-3/blade-1");
        UcsDn chassis4 = UcsDn.getDn("sys/chassis-4");
        UcsDn blade2 = UcsDn.getDn("sys/chassis-4/blade-2");

        List<UcsDn> ucsDnList = new ArrayList<>();
        ucsDnList.add(chassis4);
        ucsDnList.add(blade1);
        ucsDnList.add(blade2);
        ucsDnList.add(chassis3);

        System.out.println(ucsDnList);

        ucsDnList.sort(new UcsDnComparator());
        System.out.println(ucsDnList);
    }

    @Test
    public void testValidate() {
        ClientManager clientManager = new ClientManager(new XmlApiClientProvider(1));
        ConnectionManagerForTest connectionManager = new ConnectionManagerForTest(getRuntimeInfo(),getSecureCredentialVault());
        Connection connection = connectionManager
                .newConnection("test","https://10.172.192.15/nuova", "pippo", "pluto", true, 30);
        Assert.assertTrue(clientManager.validate(connection).isEmpty());
    }

    private static RuntimeInfo getRuntimeInfo() {
        return new RuntimeInfo() {
            @Override
            public Version getVersion() {
                return null;
            }

            @Override
            public boolean isMeridian() {
                return false;
            }

            @Override
            public Container getContainer() {
                return null;
            }

            @Override
            public String getSystemId() {
                return "";
            }

            @Override
            public String getSystemLocation() {
                return "";
            }
        };
    }

    private static SecureCredentialsVault getSecureCredentialVault() {
        return new SecureCredentialsVault() {
            @Override
            public Set<String> getAliases() {
                return Set.of();
            }

            @Override
            public Credentials getCredentials(String s) {
                return null;
            }

            @Override
            public void setCredentials(String s, Credentials credentials) {

            }

            @Override
            public void deleteCredentials(String s) {

            }
        };
    }

    @Test
    public void testSubString() {
        String alfa = "<configResolveDn dn=\"sys/fex-3\" cookie=\"1714500645/a4e3738f-2017-4170-b9ac-c52211aea725\" response=\"yes\"> <outConfig> </outConfig> </configResolveDn>";
        System.out.println(alfa.indexOf("<outConfig>")+11);
        System.out.println(alfa.indexOf("</outConfig>"));
        System.out.println(alfa.substring(alfa.indexOf("<outConfig>")+11, alfa.indexOf("</outConfig>")));
    }

    @Test
    public void getHostByNameTest() throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("51.210.12.134");
        System.out.println(ia.getHostName());
        System.out.println(ia.getHostAddress());
        System.out.println(ia.getCanonicalHostName());
        InetAddress na = InetAddress.getByName("10.1.1.1");
        System.out.println(na.getHostName());
        System.out.println(na.getHostAddress());
        System.out.println(na.getCanonicalHostName());
    }

    @Test
    public void testAbstractCollectorMethods() {
        Aggregate aggregate = Aggregate
                .builder()
                .withMin(BigDecimal.valueOf(32.37328))
                .withMax(BigDecimal.valueOf(32.37328))
                .withAverage(BigDecimal.valueOf(32.37328))
                .build();
        double value = 32.37328;
        final ImmutableNodeResource nodeResource = ImmutableNodeResource.newBuilder().setNodeId(101).build();
        final ImmutableCollectionSetResource.Builder<NodeResource> collectionSetBuilder =
                ImmutableCollectionSetResource.newBuilder(NodeResource.class).setResource(nodeResource);

        collectionSetBuilder.addStringAttribute(createStringAttribute("test", "test.dn", "abc/pppp"));
        addAggregate(collectionSetBuilder, "test","MainBoardOutlet1Agg", aggregate);
        addNumAttr(collectionSetBuilder,"test", "MainBoardOutlet1", value);

        final ImmutableCollectionSet.Builder resultBuilder = ImmutableCollectionSet.newBuilder();
        resultBuilder.addCollectionSetResource(collectionSetBuilder.build());

        CollectionSet collectionSet = resultBuilder
                .setStatus(CollectionSet.Status.SUCCEEDED)
                .setTimestamp(System.currentTimeMillis() / 1000L)
                .build()
                ;
        System.out.println(collectionSet);

    }

    @Test
    public void testProcessorDnExtraction() {
        UcsDn statDn = UcsDn.getDn("sys/chassis-1/blade-1/board/cpu-1/env-stats");
        UcsDn processorDn = UcsDn.getParentDn(statDn);
        assert processorDn != null;
        String processorId = processorDn.value.replace("/","-");
        System.out.println(processorId);
        UcsDn boardDn = UcsDn.getParentDn(processorDn);
        assert boardDn != null;
        String processorName = processorDn.value.replace(boardDn.value, "").replace("/","");
        System.out.println(processorName);

    }

}
