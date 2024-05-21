package com.gps.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI caseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicios Backend para la prueba técnica de GPS-Control")
                        .description(
                                "Documentación detallada de los servicios y esquemas para el backend de la prueba técnica de GPS-Control")
                        .version("1.0.1"));
    }
}