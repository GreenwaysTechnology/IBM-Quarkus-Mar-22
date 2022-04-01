package com.ibm.rs.response.type;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/api/books")
public class BookResource {

    @GET
    @Path("/list")
    public String getBook() {
        return "Book";
    }

    //    @GET
//    @Path("/show")
//    public void showBook() {
//        System.out.println("show Book");
//    }
    @GET
    @Path("/show")
    public Response showBook() {
        System.out.println("show Book");
        return Response.noContent().build();
    }

    @GET
    @Path("/sendBook")
    @Produces(MediaType.APPLICATION_JSON)
    public Book sendBook() {
        return new Book("Quarkus");
    }

    @GET
    @Path("/bookresponse")
    public Response sendBookResponse() {
        return Response.
                status(200)
                .entity(new Book("Quarkus Response"))
                .header("author", "Subramanian")
                .build();
    }

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON) //output type
    @Consumes(MediaType.APPLICATION_JSON)  //input type
    public Response save(Book book) {
        //Book book = new Book("Vertx");
        //books/create/1  201 created
        return Response.created(UriBuilder.fromResource(BookResource.class)
                        .path("/create/" + Long.toString(1)).build())
                .entity(book)
                .header("book", book.getName())
                .build();
    }
}
