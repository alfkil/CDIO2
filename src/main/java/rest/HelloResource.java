package rest;

import javax.ws.rs.*;

@Path("/hello")
public class HelloResource {

    @GET
    public String helloworld() {
        return "Hello World!";
    }

    @POST
    @Path("/greeting")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String postHtml(String message) {
        // Store the message
        return "Hello " + message;
    }

};
