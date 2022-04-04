package com.ibm.rs.exceptionhandling;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
//
//class CustomerIdNotFoundException extends RuntimeException {
//     public CustomerIdNotFoundException(){
//            super();
//     }
//    public CustomerIdNotFoundException(String message){
//        super(message);
//    }
//}
//
//@Provider
//class CustomerExceptionMapper implements ExceptionMapper<CustomerIdNotFoundException> {
//    @Override
//    public Response toResponse(CustomerIdNotFoundException e) {
//        return null;
//    }
//}

@Provider
public class WebApplicationMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException e) {
        // return Response.noContent().build();
        return Response.status(404)
                .entity(e.getMessage())
                .header("err", e.getResponse()
                        .getStatus()).build();
    }
}
