package org.acme.service;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

import java.util.Optional;

//since it is deprecated how to replace
//prefix is used to map property name from the configuration file - customer.id - customer.name
//@ConfigProperties(prefix = "customer")
//public class CustomerConfiguration {
//    @ConfigProperty(name = "name", defaultValue = "default Customer Name")
//    public String name;
//    @ConfigProperty(name = "id", defaultValue = "default Customer ID")
//    public String id;
//    @ConfigProperty(name = "city", defaultValue = "default Customer city")
//    public String city;
//
//}
//interface

@ConfigMapping(prefix = "customer")
public interface CustomerConfiguration {
    //property
    @WithName("name")
    Optional<String> name();
    Optional<String> id();
    Optional<String> city();
}