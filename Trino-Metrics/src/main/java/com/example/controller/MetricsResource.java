package com.example.controller;

import com.example.dto.MetricsDTO;
import com.example.service.MetricsService;
import com.google.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/metrics")
public class MetricsResource {

    private final MetricsService metricsService;

    public MetricsResource() {
        this.metricsService = new MetricsService();
    }

    @Inject
    public MetricsResource(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public MetricsDTO getMetrics() {
        return metricsService.collectMetrics();
    }
}