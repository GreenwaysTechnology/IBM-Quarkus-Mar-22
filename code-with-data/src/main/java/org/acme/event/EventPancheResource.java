package org.acme.event;

import org.acme.repository.EventPancheRepository;
import org.acme.service.enity.Event;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/api/event/panche")
public class EventPancheResource {

    @Inject
    EventPancheRepository repository;

    @GET
    public Response getEvents() {
        return Response.ok().entity(repository.listAll()).build();
    }

    @POST
    @Transactional
    public Response createEvent() {
        Event event = new Event();
        event.setTitle("Learn Quarkus with Panche");
        event.setEventDate(new Date());
        repository.persist(event);
        return Response.ok().entity(repository.listAll()).build();
    }
}
