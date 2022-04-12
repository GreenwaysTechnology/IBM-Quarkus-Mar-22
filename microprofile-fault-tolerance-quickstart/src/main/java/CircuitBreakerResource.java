import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Path("/cb")
public class CircuitBreakerResource {
    private AtomicLong counter = new AtomicLong(0);

    @GET
    @CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000)
    @Fallback(fallbackMethod = "cbFallback")
    public Response circuitBreakerApi() {
        maybeFailcb();
        return Response.ok(new Random().nextInt(30)).build();
    }

    public Response cbFallback() {
        return Response.ok().entity(100000).build();
    }

    private void maybeFailcb() {
        final Long invocationNumber = counter.getAndIncrement();
        if (invocationNumber % 4 > 1) {
            throw new RuntimeException("Service failed");
        }
    }
}
