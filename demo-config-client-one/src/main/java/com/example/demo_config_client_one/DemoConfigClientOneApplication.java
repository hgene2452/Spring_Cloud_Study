package com.example.demo_config_client_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoConfigClientOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoConfigClientOneApplication.class, args);
	}

}
