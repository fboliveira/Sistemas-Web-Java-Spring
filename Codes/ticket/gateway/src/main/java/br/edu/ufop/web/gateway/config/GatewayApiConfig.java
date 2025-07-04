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
                     .filters(f -> f.rewritePath("/api/users",
                                                "/users"))
                    .uri("lb://users-service"))
                .route("users-segment",
                    p -> p.path("/api/users/**")
                     .filters(f -> f.rewritePath("/api/users/(?<segment>.*)",
                                                "/users/${segment}"))
                    .uri("lb://sales"))
                .route("sales",
                    p -> p.path("/sales/**")
                    .uri("http://localhost:4000/sales"))
                .route("frontend",
                    p -> p.path("/**")
                    .uri(this.uriServicoFrontEnd))
                .build();
    }

}
