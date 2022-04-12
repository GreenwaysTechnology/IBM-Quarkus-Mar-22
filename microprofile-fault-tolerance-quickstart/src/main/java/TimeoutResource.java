import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/timeout")
public class TimeoutResource {

    @GET
    @Timeout(5000)
    @Fallback(fallbackMethod = "getFromCache")
    public String delay() throws InterruptedException {
        randomDelay();
        return "Hello";
    }

    private void randomDelay() throws InterruptedException {
        // introduce some artificial delay
        Thread.sleep(6000);
    }

    public String getFromCache() {
        return "Fallback Response";
    }
}
