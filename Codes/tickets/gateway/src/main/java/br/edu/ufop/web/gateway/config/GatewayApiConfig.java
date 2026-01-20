package br.edu.ufop.web.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApiConfig {

    private String frontEndUri = "http://localhost:5173";

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("users",
                        pred ->
                                pred.path("/users/**")
                                        .uri("lb://users-service")
                )

                .route("sales",
                        pred -> pred.path("/sales/**")
                                .uri("lb://sales-service")
                )

                .route("frontend",
                        pred -> pred.path("/**")
                                .uri(this.frontEndUri)
                )

                .build();
    }













}
