package it.xeniaprogetti.cisco.ucs.plugin;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("cisco-ucs")
public interface WebhookHandler {

    @GET
    @Path("/ping")
    Response ping();

}
