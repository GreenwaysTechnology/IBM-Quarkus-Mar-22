import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/bulk")
public class BulkHeadResource {

    @GET
    @Bulkhead(value = 5)
    @Fallback(fallbackMethod = "handleBulkHead")
    public Response dontOverload() {
        System.out.println("Api is called");
        return Response.ok("bulk").build();
    }

    public Response handleBulkHead() {
        System.out.println("fallback response");
        return Response.ok("sorry System busy").build();
    }
}
