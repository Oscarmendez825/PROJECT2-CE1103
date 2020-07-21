package com.ServerManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")

/***
 * This class is a trial of the data access in the server.
 * @author Oscar Méndez
 * @author Keyner Gómez
 * @author Hansel Hampton
 * @version 1.1
 * @since 2020
 */
public class HelloWorld {
    @GET
    @Path("world")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloWorld(){
        return "Hello World";

    }

}
