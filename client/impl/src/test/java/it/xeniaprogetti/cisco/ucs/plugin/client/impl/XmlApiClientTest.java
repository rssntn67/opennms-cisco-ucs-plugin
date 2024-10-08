package it.xeniaprogetti.cisco.ucs.plugin.client.impl;

import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientCredentials;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEnums;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsDataCollection;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XmlApiClientTest {

    private final static Logger LOG = LoggerFactory.getLogger(XmlApiClientTest.class);

    private static ApiClientCredentials getCredentials(int validity) {
        return ApiClientCredentials.builder()
                .withUrl("https://10.172.192.15/nuova")
                .withUsername("pippo")
                .withPassword("pluto")
                .withIgnoreSslCertificateValidation(true)
                .withValidity(validity)
                .build();
    }

    private static Map<UcsEnums.ClassId, Map<String,Set<UcsEnums.NamingClassId>>> getCollectionMap() {
        final Map<UcsEnums.ClassId, Map<String,Set<UcsEnums.NamingClassId>>> collectionItemMap = new HashMap<>();
        collectionItemMap.put(UcsEnums.ClassId.computeBlade, new HashMap<>());
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortErrStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortMcastStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorEthPortStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.adaptorVnicStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.memoryUnitEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.memoryErrorStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.processorEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.processorErrorStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalCompletionStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalProtocolStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalReceiveStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computePCIeFatalStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computeMbPowerStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.computeMbTempStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.storageDiskEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.storageSsdHealthStats);
        collectionItemMap.put(UcsEnums.ClassId.equipmentChassis, new HashMap<>());
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentFanStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentFanModuleStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentPsuStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentIOCardStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentChassisStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherNiErrStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherTxStats);
        collectionItemMap.put(UcsEnums.ClassId.networkElement, new HashMap<>());

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_FABRIC_LAN_KEY,new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY).add(UcsEnums.NamingClassId.etherTxStats);

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_FABRIC_SAN_KEY,new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY).add(UcsEnums.NamingClassId.fcErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY).add(UcsEnums.NamingClassId.fcStats);

        collectionItemMap.get(UcsEnums.ClassId.networkElement).put(UcsUtils.UCS_DN_KEY, new HashSet<>());
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentNetworkElementFanStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.equipmentPsuInputStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherLossStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherPauseStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherRxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.etherTxStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.fcErrStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.fcStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swCardEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swEnvStats);
        collectionItemMap.get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY).add(UcsEnums.NamingClassId.swSystemStats);
        return collectionItemMap;
    }

    @Test
    public void testValidate() {
        ApiClientCredentials credentials = getCredentials(30);
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Assert.assertTrue(clientProvider.validate(credentials));
    }

    @Test
    public void testXmlClientServicePool() throws ApiException, InterruptedException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        Map<Integer, XmlApiClientService> serviceMap = new HashMap<>();
        serviceMap.put(0, clientProvider.client(getCredentials(30)));
        serviceMap.put(1, clientProvider.client(getCredentials(30)));
        serviceMap.put(2, clientProvider.client(getCredentials(30)));
        serviceMap.put(3, clientProvider.client(getCredentials(30)));
        serviceMap.put(4, clientProvider.client(getCredentials(30)));
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            XmlApiClientService apiClientService = serviceMap.get(i);
            service.submit(() -> {
                try {
                    apiClientService.checkSession();
                } catch (ApiException e) {
                    // Handle exception
                }
                latch.countDown();
            });
        }
        latch.await();
        XmlApiClientService apiClientService = serviceMap.get(0);
        apiClientService.disconnect();

    }

    @Test
    public void testXmlClientServiceCheckSession() throws ApiException, InterruptedException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(550));
        service.checkSession();
        LOG.info("sleeping 30sec {}", OffsetDateTime.now());
        Thread.sleep(30000);
        LOG.info("waked up {}", OffsetDateTime.now());
        //Should do nothing
        service.checkSession();

        LOG.info("sleeping 30sec {}", OffsetDateTime.now());
        Thread.sleep(30000);
        LOG.info("waked up {}", OffsetDateTime.now());
        //Should do refresh
        service.checkSession();

        LOG.info("sleeping 60sec {}", OffsetDateTime.now());
        Thread.sleep(60000);
        LOG.info("waked up {}", OffsetDateTime.now());

        //Should do logout/login
        service.checkSession();

        service.disconnect();

    }

    @Test
    public void testXmlClientService() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));
        service.getUcsXmlFromDn("fabric/san/A", false);
        service.findDnByClassItem(UcsEnums.NamingClassId.equipmentRackEnclosure).forEach(System.out::println);

        service.findUcsIpPoolPooled().forEach(System.out::println);

        service.getUcsEquipmentChassisList().forEach(System.out::println);
        service.getUcsComputeBladeList().forEach(System.out::println);
        service.getUcsEquipmentRackEnclosureList().forEach(System.out::println);
        service.getUcsComputeRackUnitList().forEach(System.out::println);
        service.getUcsNetworkElementList().forEach(System.out::println);
        service.getUcsEquipmentFexList().forEach(System.out::println);
        LOG.info("findUcsFaultsFromDate: {}", OffsetDateTime.now());
        service.findUcsFaultsFromDate(OffsetDateTime.now().minusDays(3)).forEach(System.out::println);
        LOG.info("findAllUcsFaults: {}", OffsetDateTime.now());
        service.findAllUcsFaults().forEach(System.out::println);
        service.disconnect();
    }

    @Test
    public void testXmlClientServiceForStats() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));
        List<String> statsItemList = service.findDnByClassItem(UcsEnums.NamingClassId.statsItem);
        System.out.println(statsItemList.size());
        statsItemList.forEach(System.out::println);

        System.out.println(
                service.getUcsXmlFromDn("sys/switch-B/slot-1/switch-ether/port-106/tx-stats", false)
        );
        service.disconnect();
    }

    @Test
    public void testXmlClientServiceForSwStats() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));
        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        requestMap.put("sys/switch-A", new HashSet<>());
        requestMap.get("sys/switch-A").add(UcsEnums.NamingClassId.swEnvStats);
        requestMap.get("sys/switch-A").add(UcsEnums.NamingClassId.swSystemStats);
        requestMap.get("sys/switch-A").add(UcsEnums.NamingClassId.swCardEnvStats);
        UcsDataCollection ucsDataCollection = service.getUcsDataCollection(requestMap);
        Assert.assertTrue(ucsDataCollection.getUcsSwEnvStats().isPresent());
        Assert.assertTrue(ucsDataCollection.getUcsSwSystemStats().isPresent());
        Assert.assertTrue(ucsDataCollection.getUcsSwCardEnvStats().isEmpty());
        service.disconnect();
        System.out.println(ucsDataCollection.getUcsSwSystemStats().get());
        System.out.println(ucsDataCollection.getUcsSwEnvStats().get());
    }

    @Test
    public void testXmlClientServiceForNetworkElementStatsCollection() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));

        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var swDn = "sys/switch-A";
        var lanDn = "fabric/lan/A";
        var sanDn = "fabric/san/A";
        requestMap.put(
                swDn,
                getCollectionMap().get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_DN_KEY)
        );

        requestMap.put(
                lanDn,
                getCollectionMap().get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_LAN_KEY)
        );

        requestMap.put(
                sanDn,
                getCollectionMap().get(UcsEnums.ClassId.networkElement).get(UcsUtils.UCS_FABRIC_SAN_KEY)
        );

        UcsDataCollection stats = service.getUcsDataCollection(requestMap);
        service.disconnect();
        System.out.println(stats);

    }

    @Test
    public void testXmlClientServiceForEquipmentChassisStatsCollection() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));

        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = "sys/chassis-3";
        requestMap.put(
                dn,
                getCollectionMap().get(UcsEnums.ClassId.equipmentChassis).get(UcsUtils.UCS_DN_KEY)
        );

        UcsDataCollection stats = service.getUcsDataCollection(requestMap);
        service.disconnect();
        System.out.println(stats);

    }

    @Test
    public void testXmlClientServiceForComputeBladeStatsCollection() throws ApiException {
        XmlApiClientProvider clientProvider = new XmlApiClientProvider();
        XmlApiClientService service = clientProvider.client(getCredentials(30));

        Map<String, Set<UcsEnums.NamingClassId>> requestMap = new HashMap<>();
        var dn = "sys/chassis-3/blade-3";
        requestMap.put(
                dn,
                getCollectionMap().get(UcsEnums.ClassId.computeBlade).get(UcsUtils.UCS_DN_KEY)
        );
        UcsDataCollection stats = service.getUcsDataCollection(requestMap);
        service.disconnect();
        System.out.println(stats);

    }


}
