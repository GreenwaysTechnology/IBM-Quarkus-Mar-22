package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/hello")
public class HelloResource {

    @ConfigProperty(name = "message.greet", defaultValue = "foo message")
    String message;

    @GET
    public String sayMessage() {
        return message;
    }
}
