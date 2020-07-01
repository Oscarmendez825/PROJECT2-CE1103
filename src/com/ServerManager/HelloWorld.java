package com.ServerManager;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorld {
    @GET
    @Path("world")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHelloWorld(){
        return "Hello World";

    }

}
