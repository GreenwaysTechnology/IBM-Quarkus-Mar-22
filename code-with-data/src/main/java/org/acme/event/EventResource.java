package org.acme.event;


import org.acme.service.EventHibernateService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/events")
public class EventResource {

    @Inject
    EventHibernateService eventService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEvents() {
        return Response.ok(eventService.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent() {
        eventService.createEvent();
        return Response.status(201).entity("Event Created").build();
    }
}
