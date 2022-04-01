package com.ibm.rs.params;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/myproducts")
public class ProductResource {

    //http://localhost:8080/api/products/10
    @Path("/{productId}")
    @GET
    public String findById(@PathParam("productId") String productId) {
        return productId;
    }

    //http://localhost:8080/product/filter?category=sports
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/filter")
    public String filterProductByCategoriees(@QueryParam("category") @DefaultValue("phone") String  category) {
        System.out.println("");
        return category;
    }

    //Matrix Params
    //http://localhost:8080/api/myproducts/product;name=book;title=Java
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/product")
    public String getBookDetails(@MatrixParam("name") String name, @MatrixParam("title") String title) {
        System.out.println("");
        return name + " " + title;
    }
}
