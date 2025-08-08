package br.edu.ufop.web.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApiConfig {
    
    @Value("${gateway.frontend.uri}")
    private String uriFrontendService = "http://localhost:1234";

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder.routes()
            .route("users-api",
                p -> p.path("/api/users")
                .filters(f -> f.rewritePath("/api/users", "/users"))
                .uri("lb://users-service")
            )                   
            .route("users",
                p -> p.path("/users")
                .uri("lb://users-service")
            )               
            .route("users-segment",
                p -> p.path("/users/**")
                .uri("lb://users-service")
            )            
            .route("sales",
                p -> p.path("/sales/**")
                .uri("lb://sales-service")
            )            
            .route("notifications",
                p -> p.path("/notifications/**")
                .uri("lb://notifications-service")
            )            
            .route("frontend",
                p -> p.path("/**")
                .uri(this.uriFrontendService)
            )
            .build();

    }

}
