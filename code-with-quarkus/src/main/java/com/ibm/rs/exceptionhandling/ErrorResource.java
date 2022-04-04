package com.ibm.rs.exceptionhandling;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@Path("/myerrros")
public class ErrorResource {
    @GET
    @Path("{id}")
    public Response getResponse(@PathParam("id") String id) {
        if (id.equals("100")) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok("Sucess" + id).build();
    }
}
