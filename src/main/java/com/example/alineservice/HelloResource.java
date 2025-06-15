package com.example.alineservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world-1")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World! and welcome to Aline Service!";
    }

    @GET
    @Path("/test")
    @Produces("text/plain")
    public String helloTest() {
        return "Hello, World! test";
    }

}