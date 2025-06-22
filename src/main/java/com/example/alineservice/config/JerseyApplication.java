package com.example.alineservice.config;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class JerseyApplication extends ResourceConfig {
    public JerseyApplication() {
        packages(
                "com.example.alineservice.controller",
                "com.example.alineservice.controller.usuario",
                "com.example.alineservice.controller.sesion",
                "com.example.alineservice.config"
        );
    }
}
