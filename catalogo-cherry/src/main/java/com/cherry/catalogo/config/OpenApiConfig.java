package com.cherry.catalogo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI catalogoOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Catalogo Cherry API")
                .description("API para administrar el catalogo de vestidos")
                .version("1.0"));
    }
}
