package com.ibm.rs.di;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Producers {
    //instance variable ; going to be as dependency to some other classes
    @Produces
    double price = 1000.00;

    //instance method ; going to be as dependency to some other class
    @Produces
    List<String> topics(){
        List<String> topics = new ArrayList<>();
        topics.add("cdi");
        topics.add("configuration");
        topics.add("RestEasy");
        return topics;
    }
}
