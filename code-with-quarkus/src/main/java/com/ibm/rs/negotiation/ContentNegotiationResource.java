package com.ibm.rs.negotiation;


import com.ibm.rs.User;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Locale;

@Path("/negotiation")
public class ContentNegotiationResource {
    @GET
    @Path("/content")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response negotiateContent() {
        User user = new User(1, "admin");
        return Response.ok(user).build();
    }

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(User user) {
        System.out.println("User " + user);
        return Response.status(201).entity("Created").build();
    }
    //language
    // GET /negotiation/lang
    //Accept-language : en

    @Path("/lang")
    @GET
    public Response getLang(@Context Request request) {

        List<Variant> variants = Variant.VariantListBuilder
                .newInstance()
                .languages(Locale.ENGLISH, Locale.GERMAN)
                .build();


        Variant variant = request.selectVariant(variants);

        if (variant == null) {
            return Response.notAcceptable(variants).build();
        }
        String language = variant.getLanguageString();
        return Response.ok(language)
                .header(HttpHeaders.CONTENT_LANGUAGE, language)
                .build();
    }
}
