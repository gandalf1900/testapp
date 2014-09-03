package no.web.rest;

import no.web.model.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/person")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{firstName}/{lastName}")
    public Person getData(@PathParam("firstName") String firstName, @PathParam("lastName") String lastName ) {
        return new Person(firstName, lastName, 25);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersons() {
        List<Person> lists = new ArrayList<Person>();
        lists.add(new Person("frodo","baggins", 100));
        lists.add(new Person("gandalf", "white", 300));
        return lists;
    }
}

