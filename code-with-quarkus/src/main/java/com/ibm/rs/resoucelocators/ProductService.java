package com.ibm.rs.resoucelocators;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class ProductService {
    @GET
    public String getPayments() {
        return "Service  resource";
    }
    @GET
    @Path("{id}")
    public String getPaymentById(@PathParam("id") String id) {
        return "Services resource by id" + id;
    }
}
