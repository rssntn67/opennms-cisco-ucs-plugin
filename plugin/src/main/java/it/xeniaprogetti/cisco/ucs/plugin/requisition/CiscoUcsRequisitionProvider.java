package it.xeniaprogetti.cisco.ucs.plugin.requisition;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.xeniaprogetti.cisco.ucs.plugin.client.ClientManager;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiClientService;
import it.xeniaprogetti.cisco.ucs.plugin.client.api.ApiException;
import it.xeniaprogetti.cisco.ucs.plugin.connection.ConnectionManager;
import org.opennms.integration.api.v1.config.requisition.Requisition;
import org.opennms.integration.api.v1.config.requisition.immutables.ImmutableRequisition;
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

        return requisition.build();
    }

    public static class Request implements RequisitionRequest {

        private String alias;

        private String foreignSource;

        private String location;

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

        public ApiClientService client() throws ApiException {
            var connection =  connectionManager.getConnection(request.alias);
            if (connection.isEmpty()) {
                throw new ApiException("No connection for alias", new NullPointerException("No connection found for "+ request.alias));
            }
            if (clientManager.validate(connection.get()).isEmpty()) {
                LOG.info("Using Default Connection Alias {}", request.alias);
                return clientManager.getClient(connection.get());
            }
            throw new ApiException("Connection for alias is not valid and no pool available", new NullPointerException("Connection is not valid for " + request.alias));
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
