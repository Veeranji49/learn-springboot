package com.example.config;

import com.example.controller.MetricsResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.example.controller");
        register(MetricsResource.class);
    }
}