package org.acme.user;

import org.acme.service.CustomerJdbcService;
import org.acme.service.UserJDBCService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/customers")
public class CustomerResource {

    @Inject
    CustomerJdbcService customerJdbcService;

    @GET
    public Response getUsers() {
        return Response.ok().entity(customerJdbcService.listCustomers()).build();
    }
}
