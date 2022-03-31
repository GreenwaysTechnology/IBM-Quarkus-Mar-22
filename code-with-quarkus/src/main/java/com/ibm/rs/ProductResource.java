package com.ibm.rs;

import javax.ws.rs.*;

@Path("/api/products")
public class ProductResource {
    //methods
    @Path("/list")
    @GET
    public String findAl() {
        return "FindAll Products!!!!!";
    }

    @POST
    @Path("/create")
    public String create() {
        return "Created...!!!!";
    }

    @PUT
    @Path("/update")
    public String update() {
        return "updated";
    }

    @Path("/remove")
    @DELETE
    public String remove() {
        return "Deleted";
    }
}
