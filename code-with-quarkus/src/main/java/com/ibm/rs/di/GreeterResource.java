package com.ibm.rs.di;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
public class GreeterResource {
    //DI - field
//    @Inject
//    private HelloService helloService;

    //setter injection
//    private HelloService helloService;
//
//    public GreeterResource() {
//    }

    //constructor Injection
    private HelloService helloService;

    //    @Inject
//    public GreeterResource(HelloService helloService) {
//        this.helloService = helloService;
//    }
    public GreeterResource(HelloService helloService) {
        this.helloService = helloService;
    }

//

    @GET
    @Path("/hello")
    public Response sayHello() {
        return Response.ok(helloService.sayHello()).build();
    }
}
