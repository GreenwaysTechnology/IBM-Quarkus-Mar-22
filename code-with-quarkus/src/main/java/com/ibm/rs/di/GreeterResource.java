package com.ibm.rs.di;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/greeter")
public class GreeterResource {
    //DI - field
    @Inject
    private HelloService helloService;

    @GET
    @Path("/hello")
    public Response sayHello() {
        return Response.ok(helloService.sayHello()).build();
    }
}
