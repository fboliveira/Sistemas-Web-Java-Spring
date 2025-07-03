package br.edu.ufop.web.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class GatewayApiConfig {

    @Value("${gateway.frontend-uri}")
    private String uriServicoFrontEnd = "http://localhost:1234";

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("users",
                    p -> p.path("/api/users")
                    .uri("http://localhost:3000"))
                .route("sales",
                    p -> p.path("/api/users")
                    .uri("http://localhost:4000"))
                .route("frontend",
                    p -> p.path("/**")
                    .uri(this.uriServicoFrontEnd))
                .build();
    }

}
