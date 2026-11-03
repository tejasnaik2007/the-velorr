package com.leema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class LeemaApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LeemaApplication.class);
        // All configuration lives in Java (no application.properties). Port 8081 so it can run beside other apps.
        app.setDefaultProperties(Map.of(
                "server.port", "8081",
                "server.error.whitelabel.enabled", "false",
                "spring.main.banner-mode", "off"));
        app.run(args);
    }
}
