package org.acme;

import org.acme.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/customer")
public class CustomeResource {

    @Inject
    CustomerService customerService;

    @GET
    public String getCustomerInfo() {
        return customerService.getCustomerId() + " " + customerService.getCustomerName() + " " + customerService.getCustomerCity();
    }
}
