package com.ibm.rs.di;

import javax.enterprise.context.ApplicationScoped;

@HaiQualifier
@ApplicationScoped
public class Hai implements Greeter {
    @Override
    public String sayGreet() {
        return "Hai";
    }
}
