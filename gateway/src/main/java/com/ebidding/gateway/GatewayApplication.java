package com.ebidding.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // if user =>
                // http://localhost:8080/api/v1/accounts?name=test-client
                // api/v1/accounts

                .route("account-service", r -> r.path("/api/v1/accounts/**")
                        .uri("http://localhost:8001"))
                .route("bid-service", r -> r.path("/api/v1/bids/**")
                        .uri("http://localhost:8002"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
