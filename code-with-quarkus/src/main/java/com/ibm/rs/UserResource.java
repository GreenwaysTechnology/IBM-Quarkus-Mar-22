package com.ibm.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
public class UserResource {
    //send json
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public User findUser() {
        User user = new User(1, "Subramanian Murugan");
        return user;
    }
}
