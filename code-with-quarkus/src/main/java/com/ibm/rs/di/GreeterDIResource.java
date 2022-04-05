package com.ibm.rs.di;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/greeter/greet")
public class GreeterDIResource {

    //this works only if there is only one implementation
//    @Inject @Default
//    private Greeter greeter;
//    @Inject
//    @HaiQualifier
//    private Greeter haigreeter;
//
//    @Inject
//    @HelloQualifier
//    private Greeter hellogreeter;

    //code refactoring without @Inject itself it works
    @HaiQualifier
    Greeter haigreeter;

    @HelloQualifier
    Greeter hellogreeter;

    @GET
    public String sayGreet() {
        return haigreeter.sayGreet() + " " + hellogreeter.sayGreet();
    }

}
