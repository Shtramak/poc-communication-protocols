package com.bobocode.petros.openapiserver.configuration;

import com.bobocode.petros.openapi.client.api.PersonApiApi;
import com.bobocode.petros.openapi.client.client.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }

    @Autowired
    public ObjectMapper objectMapper(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    @Bean
    public PersonApiApi personApi(RestTemplate restTemplate, @Value("${api.config.rootUri}") String rootUri) {
        var apiClient = new ApiClient(restTemplate);
        apiClient.setBasePath(rootUri);
        return new PersonApiApi(apiClient);
    }
}
