package com.ibm.rs.resoucelocators;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

public class PaymentResource {
    @GET
    public String getPayments() {
        return "Payment resource";
    }
    @GET
    @Path("{id}")
    public String getPaymentById(@PathParam("id") String id) {
        return "Payments resource by id" + id;
    }
}
