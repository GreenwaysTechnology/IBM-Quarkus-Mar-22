package org.acme.user;

import org.acme.service.UserJDBCService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/users")
public class UserResource {

    @Inject
    UserJDBCService userJDBCService;

    @GET
    public Response getUsers() {
        return Response.ok().entity(userJDBCService.listUsers()).build();
    }
}
