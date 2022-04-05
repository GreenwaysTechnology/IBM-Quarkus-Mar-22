package com.ibm.rs.di;

import com.ibm.rs.di.interceptors.LogEvent;

import javax.enterprise.context.ApplicationScoped;

@HelloQualifier
@ApplicationScoped
public class Hello implements Greeter {

    @Override
    @LogEvent
    public String sayGreet() {
        return "Hello How are you!";
    }
}
