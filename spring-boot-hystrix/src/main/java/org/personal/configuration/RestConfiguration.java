package org.personal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Value("${rest.connection-timeout}")
    private int connectionTimeout;

    @Value("${rest.read-timeout}")
    private int readTimeout;


    @Bean
    public RestTemplate getLibraryRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .setReadTimeout(readTimeout)
                .setConnectTimeout(connectionTimeout)
                .build();
    }
}