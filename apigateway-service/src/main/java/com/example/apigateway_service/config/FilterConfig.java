package com.example.apigateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// application.yml 을 통해 설정할 경우 주석처리
// @Configuration
public class FilterConfig {

	// @Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(r -> r.path("/first-service/**")
						 .filters(f -> f.addRequestHeader("first-request", "first-request-header")
									    .addResponseHeader("first-response", "first-response-header"))
						 .uri("http://127.0.0.1:8081"))
			.route(r -> r.path("/second-service/**")
						 .filters(f -> f.addRequestHeader("second-request", "second-request-header")
									    .addResponseHeader("second-response", "second-response-header"))
						 .uri("http://127.0.0.1:8082"))
			.build();
	}
}
