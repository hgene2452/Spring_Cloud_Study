package com.example.demo_config_client_one;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@ToString
@RefreshScope
@ConfigurationProperties("com.web3")
public class Config {
    private String profile;
}
