package org.acme.panche.resource;

import org.acme.service.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/person")
public class PersonResource {

    @Inject
    PersonService personService;

    @GET
    public Response findAll() {
        // return Response.ok().entity(Person.listAll()).build();
        return Response.ok().entity(personService.findAll()).build();
    }

    @POST
    @Path("/create")
    public Response createPerson() {
        return Response.ok(personService.createPerson()).build();
    }
}
