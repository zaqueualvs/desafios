package com.alves.picpaysimplificado.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configurations {

    @Bean
    public WebClient createWebcliente() {
        return WebClient.create();
    }
}
