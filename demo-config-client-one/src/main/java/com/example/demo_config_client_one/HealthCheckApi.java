package com.example.demo_config_client_one;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class HealthCheckApi {

    private final Environment env;

    @GetMapping("/")
    public String healthCheck() {
        return String.format("app is up and running\nstatus: %s", env.getProperty("status"));
    }
}
