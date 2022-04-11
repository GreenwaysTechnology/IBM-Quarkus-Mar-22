package org.acme.vertx;

import io.smallrye.mutiny.Uni;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.HttpResponse;
import io.vertx.mutiny.ext.web.client.WebClient;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/myclient")
public class WebClientResource {
    @Inject
    Vertx vertx; // Inject the managed io.vertx.mutiny.core.Vertx instance
    private WebClient client;

    //
    @PostConstruct
    public void init() {
        System.out.println("init");
        client = WebClient.create(vertx, new WebClientOptions()
                .setDefaultHost("localhost")
                .setDefaultPort(8080)
        );
    }

    @GET
    public Uni<String> Myapi() {
        return client
                .get("/hello").send()
                .onItem().transform(HttpResponse::bodyAsString);
    }
}
