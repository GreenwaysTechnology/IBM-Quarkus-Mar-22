package org.acme;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    //this api is handled by event loop threads: non blocking threads
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        System.out.println(" Thread => " + Thread.currentThread().getName());
        return Uni.createFrom().item("Hello Reactive");
    }

    @GET
    @Path("/blockme")
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public Uni<String> blockMe() {
        System.out.println(" Thread => " + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Uni.createFrom().item("Hello Blocking Code");
    }
}