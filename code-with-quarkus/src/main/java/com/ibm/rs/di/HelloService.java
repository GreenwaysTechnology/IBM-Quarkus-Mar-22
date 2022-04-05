package com.ibm.rs.di;

import com.ibm.rs.di.interceptors.LogEvent;

import javax.enterprise.context.ApplicationScoped;

//Bean
@ApplicationScoped
public class HelloService {
    public String sayHello() {
        return "Hello Constructor Injection!!!!";
    }
}
