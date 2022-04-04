package com.ibm.rs.resoucelocators;

import javax.ws.rs.Path;

@Path("/api/ibm")
public class Application {
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
}
