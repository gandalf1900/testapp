package no.web.rest;

import no.web.model.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeResource {

    @GET
    List<Employee> getAll();

    @GET
    @Path("{id}")
    Employee get(@PathParam("id") Long id);

    @POST
    Response add(Employee employee);

    @PUT
    @Path("{id}")
    Response update(@PathParam("id") Long id, Employee employee);

    @DELETE
    @Path("{id}")
    Response remove(@PathParam("id") Long id);

}