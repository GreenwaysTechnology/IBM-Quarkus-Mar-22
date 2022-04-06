package org.acme.service;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    //inject application.property file property
    @ConfigProperty(name = "greeting.message", defaultValue = "default")
    String message;
    @ConfigProperty(name = "greeter.name", defaultValue = "foo")
    String name;
    @ConfigProperty(name = "greeter.date", defaultValue = "today")
    String date;

    public String sayHello() {
        return message + "  =>  " + name + " " + date;
    }

    public String getUserInfo() {
        Config config = ConfigProvider.getConfig();
        // return config.getValue("myuser.name", String.class);
        return config.getOptionalValue("myuser.name", String.class).orElse("bar");
    }
    public String configFolder() {
        Config config = ConfigProvider.getConfig();
        // return config.getValue("myuser.name", String.class);
        return config.getOptionalValue("myprop.value", String.class).orElse("bar");
    }
}
