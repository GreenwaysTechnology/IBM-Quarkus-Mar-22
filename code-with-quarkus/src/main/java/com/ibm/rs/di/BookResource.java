package com.ibm.rs.di;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/book")
public class BookResource {
    @Inject
    BookService bookService;

    @GET
    public Response createBook(){
        return Response.ok(bookService.createBook()).build();
    }
}
