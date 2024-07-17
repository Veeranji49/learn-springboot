package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("JWT Swagger Configuration"))
                .addSecurityItem(new SecurityRequirement().addList("JWT Swagger Configuration"))
                .components(new Components().addSecuritySchemes("JWT Swagger Configuration", new SecurityScheme()
                        .name("JWT Swagger Configuration").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));

    }
}