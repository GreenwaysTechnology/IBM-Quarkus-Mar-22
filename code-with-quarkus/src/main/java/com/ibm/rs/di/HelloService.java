package com.ibm.rs.di;

import javax.enterprise.context.ApplicationScoped;

//Bean
@ApplicationScoped
public class HelloService {
    public String sayHello() {
        return "Hello!!!";
    }
}
