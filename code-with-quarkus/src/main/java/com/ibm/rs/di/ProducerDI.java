package com.ibm.rs.di;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/producer")
public class ProducerDI {

    @Inject
    double price;
    @Inject
    List<String> topics;


    @GET
    @Path("/price")
    public Response getPrice() {
        return Response.ok().entity(price).build();
    }
    @GET
    @Path("/topics")
    public Response getTopics() {
        return Response.ok().entity(topics).build();
    }
}
