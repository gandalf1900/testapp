package no.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/echo")
public class EchoResource {
    @GET
    @Path("/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public String echo(@PathParam("message")String message){
        return message;
    }
}
