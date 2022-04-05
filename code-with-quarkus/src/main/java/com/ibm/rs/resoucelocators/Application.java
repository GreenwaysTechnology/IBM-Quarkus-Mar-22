package com.ibm.rs.resoucelocators;

import com.ibm.rs.di.GreeterResource;

import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

@Path("/api/ibm")
public class Application {
    @Context
    ResourceContext resourceContext;
    //payment
    @Path("/payments")
    public PaymentResource getPaymentResource() {
        return new PaymentResource();
    }
    //Services
    @Path("/services")
    public ProductService getProductService(){
          return new ProductService();
    }
    @Path("/greeter")
    public GreeterResource getGreeterResource(){
        return resourceContext.getResource(GreeterResource.class);
    }
}
