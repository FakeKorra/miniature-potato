package com.simul_tech.netgenius.configurators;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .servers(
                        List.of(
                                new Server().url("http://localhost:8080")
                        )
                )
                .info(
                        new Info()
                                .title("Net-Genius API")
                                .description("API для управления студентами и аутентификации")
                                .version("1.0")
                                .contact(new Contact()
                                        .name("Support")
                                        .email("support@netgenius.com"))
                );
    }
}
@Bean
public OpenAPI api() {
    return new OpenAPI()
        .servers(List.of(new Server().url("http://localhost:8080")))
        .info(new Info()
            .title("Net-Genius API")
            .description("API для управления студентами и аутентификации")
            .version("1.0"));
}