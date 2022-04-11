package org.acme.vertx;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventConsumer {
    //method which
    @ConsumeEvent("ibm.greet")
    public void handler(Message<JsonObject> name) {
        System.out.println(name.body().encodePrettily());
    }
}
