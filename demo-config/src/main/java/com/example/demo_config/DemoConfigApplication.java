package com.example.demo_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DemoConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigApplication.class, args);
	}

}
