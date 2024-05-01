package it.xeniaprogetti.cisco.ucs.plugin.requisition;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeBlade;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsComputeRackUnit;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentChassis;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentFex;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsEquipmentRackEnclosure;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.UcsNetworkElement;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.config.requisition.Requisition;
import org.opennms.integration.api.v1.config.requisition.RequisitionNode;
import org.opennms.integration.api.v1.config.requisition.immutables.ImmutableRequisition;
import org.opennms.integration.api.v1.config.requisition.immutables.ImmutableRequisitionMetaData;
import org.opennms.integration.api.v1.config.requisition.immutables.ImmutableRequisitionNode;
import org.opennms.integration.api.v1.dao.NodeDao;
import org.opennms.integration.api.v1.requisition.RequisitionProvider;
import org.opennms.integration.api.v1.requisition.RequisitionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CiscoUcsRequisitionProvider implements RequisitionProvider {

    private final NodeDao nodeDao;
    private final ConnectionManager connectionManager;
    private final ClientManager clientManager;
    public final static String TYPE = "cisco-ucs";

    private static final Logger LOG = LoggerFactory.getLogger( CiscoUcsRequisitionProvider.class);

    public static final String CISCO_UCS_METADATA_CONTEXT = "cisco-ucs";

    public static final String PARAMETER_FOREIGN_SOURCE = "foreignSource";

    public final static String PARAMETER_ALIAS="alias";
    public final static String PARAMETER_LOCATION="location";
    public final static String PARAMETER_IMPORT_NETWORK_ELEMENT="importNetworkElement";
    public final static String PARAMETER_IMPORT_COMPUTE_BLADE="importComputeBlade";
    public final static String PARAMETER_IMPORT_COMPUTE_RACK_UNIT ="importComputeRackUnit";
    public final static String PARAMETER_IMPORT_EQUIPMENT_CHASSIS="importEquipmentChassis";
    public final static String PARAMETER_IMPORT_EQUIPMENT_FEX="importEquipmentFex";
    public final static String PARAMETER_IMPORT_EQUIPMENT_RACK_ENCLOSURE="importEquipmentRackEnclosure";


    public CiscoUcsRequisitionProvider(final NodeDao nodeDao, final ConnectionManager connectionManager, final ClientManager clientManager) {
        this.nodeDao = Objects.requireNonNull(nodeDao);
        this.connectionManager = Objects.requireNonNull(connectionManager);
        this.clientManager = Objects.requireNonNull(clientManager);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public final RequisitionRequest getRequest(final Map<String, String> parameters) {
        final var alias = Objects.requireNonNull(parameters.get(PARAMETER_ALIAS), "Missing requisition parameter: alias");
        final var location = Objects.requireNonNullElse(parameters.get(PARAMETER_LOCATION), nodeDao.getDefaultLocationName());

        final var request = new Request(alias,location);

        if (parameters.containsKey(PARAMETER_FOREIGN_SOURCE)) {
            request.foreignSource=parameters.get(PARAMETER_FOREIGN_SOURCE);
        }

        if (parameters.containsKey(PARAMETER_IMPORT_NETWORK_ELEMENT)) {
            request.importNetworkElement=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_NETWORK_ELEMENT));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_COMPUTE_BLADE)) {
            request.importComputeBlade=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_COMPUTE_BLADE));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_COMPUTE_RACK_UNIT)) {
            request.importComputeRackUnit=Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_COMPUTE_RACK_UNIT));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_EQUIPMENT_CHASSIS)) {
            request.importEquipmentChassis = Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_EQUIPMENT_CHASSIS));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_EQUIPMENT_FEX)) {
            request.importEquipmentFex = Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_EQUIPMENT_FEX));
        }

        if (parameters.containsKey(PARAMETER_IMPORT_EQUIPMENT_RACK_ENCLOSURE)) {
            request.importEquipmentRackEnclosure = Boolean.parseBoolean(parameters.get(PARAMETER_IMPORT_EQUIPMENT_RACK_ENCLOSURE));
        }
        return request;
    }

    @Override
    public final Requisition getRequisition(final RequisitionRequest rawRequest) {
        final var request = (Request) rawRequest;
        try {
            return handleRequest(new RequestContext(request));
        } catch (ApiException e) {
            LOG.error("getRequisition: Cisco UCS Manager communication failed", e);
            throw new RuntimeException("Cisco UCS Manager prism communication failed", e);
        }
    }


    protected Requisition handleRequest(final RequestContext context) throws ApiException {
        var request = (Request) context.getRequest();

        final var requisition = ImmutableRequisition.newBuilder()
                .setForeignSource(context.request.foreignSource);

        ApiClientService service = context.client();

        if (request.importNetworkElement) {
            service.getUcsNetworkElementList()
                .forEach(element -> requisition.addNode(from(element, context)));
        }

        if (request.importComputeBlade) {
            service.getUcsComputeBladeList()
                    .forEach(element -> requisition.addNode(from(element, context)));
        }

        if (request.importComputeRackUnit) {
            service.getUcsComputeRackUnitList()
                    .forEach(element -> requisition.addNode(from(element, context)));
        }

        if (request.importEquipmentChassis) {
            service.getUcsEquipmentChassisList()
                    .forEach(element -> requisition.addNode(from(element, context)));
        }

        if (request.importEquipmentFex) {
            service.getUcsEquipmentFexList()
                    .forEach(element -> requisition.addNode(from(element, context)));
        }

        if (request.importEquipmentRackEnclosure) {
            service.getUcsEquipmentRackEnclosureList()
                    .forEach(element -> requisition.addNode(from(element, context)));
        }

        return requisition.build();
    }

    private RequisitionNode from(UcsNetworkElement ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }

    private RequisitionNode from(UcsComputeBlade ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }

    private RequisitionNode from(UcsComputeRackUnit ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }

    private RequisitionNode from(UcsEquipmentChassis ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }

    private RequisitionNode from(UcsEquipmentFex ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }

    private RequisitionNode from(UcsEquipmentRackEnclosure ucsElement, RequestContext context) {
        final var node = ImmutableRequisitionNode.newBuilder()
                .setForeignId(ucsElement.dn)
                .setLocation(context.getLocation())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("alias")
                        .setValue(context.getAlias())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("type")
                        .setValue(ucsElement.classId.name())
                        .build())
                .addMetaData(ImmutableRequisitionMetaData.newBuilder()
                        .setContext(CISCO_UCS_METADATA_CONTEXT)
                        .setKey("item")
                        .setValue(ucsElement.classItem.name())
                        .build())
                ;
        return node.build();
    }



    public static class Request implements RequisitionRequest {

        private final String alias;
        private final String location;

        private String foreignSource;
        private boolean importNetworkElement = true;
        private boolean importComputeBlade = true;
        private boolean importComputeRackUnit = true;
        private boolean importEquipmentChassis = true;
        private boolean importEquipmentFex = true;
        private boolean importEquipmentRackEnclosure = true;


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

        public ApiClientService client() throws ApiException {
            var connection =  connectionManager.getConnection(request.alias);
            if (connection.isEmpty()) {
                throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ request.alias));
            }
           LOG.info("client: requesting Alias {}", request.alias);
           return clientManager.getClient(connection.get());
        }

        public String getAlias() {
            return this.request.alias;
        }

        public String getLocation() {
            return this.request.location;
        }

        public Request getRequest() {
            return request;
        }
    }

    @Override
    public final byte[] marshalRequest(final RequisitionRequest request) {
        final var mapper = new XmlMapper();
        try {
            return mapper.writeValueAsBytes(request);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final RequisitionRequest unmarshalRequest(final byte[] bytes) {
        final var mapper = new XmlMapper();
        try {
            return mapper.readValue(bytes, RequisitionRequest.class);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

}
