package it.xeniaprogetti.cisco.ucs.plugin.requisition;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import it.xeniaprogetti.cisco.ucs.plugin.snmp.CiscoUcsComputeBoardTableTracker;
import org.opennms.integration.api.v1.config.requisition.Requisition;
import org.opennms.integration.api.v1.config.requisition.immutables.ImmutableRequisition;
import org.opennms.integration.api.v1.dao.NodeDao;
import org.opennms.integration.api.v1.requisition.RequisitionProvider;
import org.opennms.integration.api.v1.requisition.RequisitionRequest;
import org.opennms.netmgt.config.api.SnmpAgentConfigFactory;
import org.opennms.netmgt.snmp.proxy.LocationAwareSnmpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.xeniaprogetti.cisco.ucs.plugin.snmp.CiscoUcsVmInstanceTableTracker;

public class CiscoUcsRequisitionProvider implements RequisitionProvider {
    private final LocationAwareSnmpClient locationAwareSnmpClient;

    private final NodeDao nodeDao;
    public final static String TYPE = "cisco-ucs";

    private static final Logger LOG = LoggerFactory.getLogger( CiscoUcsRequisitionProvider.class);

    public static final String CISCO_UCS_METADATA_CONTEXT = "cisco-ucs";
    public static final String PARAMETER_FOREIGN_SOURCE = "foreignSource";

    public final static String PARAMETER_ALIAS="alias";
    public final static String PARAMETER_LOCATION="location";

    public final static String PARAMETER_IMPORT_VMS="importVms";
    public final static String PARAMETER_IMPORT_ALL_VMS="importALLVms";
    public final static String PARAMETER_IMPORT_HOSTS ="importHosts";

    public final static String PARAMETER_IMPORT_CLUSTERS="importClusters";

    public final static String PARAMETER_MATCH_VM="matchVM";

    public CiscoUcsRequisitionProvider(final NodeDao nodeDao,
                           final LocationAwareSnmpClient locationAwareSnmpClient) {
        this.nodeDao = nodeDao;
        this.locationAwareSnmpClient = locationAwareSnmpClient;

    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public final RequisitionRequest getRequest(final Map<String, String> parameters) {
        final var alias = Objects.requireNonNull(parameters.get(PARAMETER_ALIAS), "Missing requisition parameter: alias");

        final var request = new Request(alias,"default");

        if (parameters.containsKey(PARAMETER_FOREIGN_SOURCE)) {
            request.foreignSource=parameters.get(PARAMETER_FOREIGN_SOURCE);
        }

        if (parameters.containsKey(PARAMETER_IMPORT_VMS)) {
            request.importVms=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_VMS));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_ALL_VMS)) {
            request.importAllVms=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_ALL_VMS));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_HOSTS)) {
            request.importHosts=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_HOSTS));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_CLUSTERS)) {
            request.importClusters=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_CLUSTERS));
        }

        if (parameters.containsKey(PARAMETER_MATCH_VM)) {
            request.matchVM=parameters.get(PARAMETER_MATCH_VM);
        }

        return request;
    }

    @Override
    public final Requisition getRequisition(final RequisitionRequest rawRequest) {
        final var request = (Request) rawRequest;
        return handleRequest(new RequestContext(request));
    }


    protected Requisition handleRequest(final RequestContext context)  {
        var request = (Request) context.getRequest();

        final var requisition = ImmutableRequisition.newBuilder()
                .setForeignSource(context.request.foreignSource);

        CiscoUcsVmInstanceTableTracker vmInstanceTableTracker = new CiscoUcsVmInstanceTableTracker();
        CiscoUcsComputeBoardTableTracker computeBoardTableTracker = new CiscoUcsComputeBoardTableTracker();



        return requisition.build();
    }
    public static class Request implements RequisitionRequest {

        private String alias;
        private boolean importVms = true;
        private boolean importHosts = true;

        private boolean importClusters = true;

        private boolean importAllVms = false;

        private String foreignSource;

        private String location;

        private String matchVM;

        public Request() {
        }

        public Request(String alias, String location) {
            this.alias = Objects.requireNonNull(alias);
            this.location = Objects.requireNonNull(location);
            this.foreignSource = String.format("%s-%s", TYPE, alias);
        }
    }

    public class RequestContext {
        private final Request request;

        public RequestContext(final Request request) {
            this.request = Objects.requireNonNull(request);
        }

        public Request getRequest() {
            return this.request;
        }
        public String getAlias() {
            return this.request.alias;
        }

        public String getLocation() {
            return this.request.location;
        }
    }

    @Override
    public final byte[] marshalRequest(final RequisitionRequest request) {
        final var mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(request);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final RequisitionRequest unmarshalRequest(final byte[] bytes) {
        final var mapper = new ObjectMapper();
        try {
            return mapper.readValue(bytes, RequisitionRequest.class);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

}
