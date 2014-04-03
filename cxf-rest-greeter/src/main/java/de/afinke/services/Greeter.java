package de.afinke.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/greeter")
public class Greeter {

    @GET
    @Produces("text/plain")
    public String greet() {
        return "Greetings!";
    }
}
