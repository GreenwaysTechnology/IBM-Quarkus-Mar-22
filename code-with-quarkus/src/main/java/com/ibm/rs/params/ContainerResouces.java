package com.ibm.rs.params;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/api/containerResource")
public class ContainerResouces {

    @Produces(MediaType.TEXT_PLAIN)
    @GET()
    @Path("/urls")
    public String getUriInfo(@Context UriInfo uriInfo) {
        System.out.println(uriInfo.getAbsolutePath() + " " + uriInfo.getRequestUri());
        return uriInfo.getAbsolutePath() + " " +uriInfo.getRequestUri();
    }

    @Produces(MediaType.TEXT_PLAIN)
    @GET()
    @Path("/headers")
    public String getHeaders(@Context HttpHeaders headers) {
        System.out.println(headers.getRequestHeaders());
        return "headers Information";
    }

    @Produces(MediaType.TEXT_PLAIN)
    @GET()
    @Path("/header")
    public String getHeader(@HeaderParam("User-Agent") MediaType mediaType) {
        System.out.println(mediaType.getType());
        return mediaType.getType().trim();
    }
}
