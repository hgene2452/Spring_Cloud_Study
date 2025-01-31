package com.example.apigateway_service.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<LoggingFilter.Config> {

	public LoggingFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// Logging Pre Filter
		// return ((exchange, chain) -> {
		// 	ServerHttpRequest request = exchange.getRequest();
		// 	ServerHttpResponse response = exchange.getResponse();
		//
		// 	log.info("Global filter base message: {}", config.getBaseMessage());
		//
		// 	if (config.isPreLogger()) {
		// 		log.info("Global Filter Start: request id -> {}", request.getId());
		// 	}
		//
		// 	// Logging Post Filter
		// 	return chain.filter(exchange).then(Mono.fromRunnable(() -> {
		// 		if (config.isPostLogger()) {
		// 			log.info("Global Filter End: response code -> {}", response.getStatusCode());
		// 		}
		// 	}));
		// });

		GatewayFilter filter = new OrderedGatewayFilter((exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();

			log.info("Logging Filter base message: {}", config.getBaseMessage());

			if (config.isPreLogger()) {
				log.info("Logging Filter Start: request id -> {}", request.getId());
			}

			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				if (config.isPostLogger()) {
					log.info("Logging Filter End: response code -> {}", response.getStatusCode());
				}
			}));
		}, Ordered.HIGHEST_PRECEDENCE);

		return filter;
	}

	@Data
	public static class Config {
		// Put the configuration properties
		private String baseMessage;
		private boolean preLogger;
		private boolean postLogger;
	}
}
