package com.example.demo_config_client_one;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final Config config;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/config")
    public String config() {
        return config.toString();
    }
}
