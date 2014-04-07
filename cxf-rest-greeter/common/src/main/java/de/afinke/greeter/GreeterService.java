package de.afinke.greeter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/greeter")
public interface GreeterService {

    @GET
    @Produces("text/plain")
    public String greet();

}
