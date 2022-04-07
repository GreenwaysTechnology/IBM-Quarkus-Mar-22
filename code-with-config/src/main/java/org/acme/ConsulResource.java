package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/consul")
public class ConsulResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Hello consul")
    String message;

    @GET
    public String getConsul() {
        return message;
    }

}
