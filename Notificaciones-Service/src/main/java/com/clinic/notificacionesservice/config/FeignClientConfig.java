package com.clinic.notificacionesservice.config;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignClientConfig {
    @Bean
    public RequestInterceptor keycloakFeignInterceptor() {
        return new KeycloakFeignInterceptor();
    }
}