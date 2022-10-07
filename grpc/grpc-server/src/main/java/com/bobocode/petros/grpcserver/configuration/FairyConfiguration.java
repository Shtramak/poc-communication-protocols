package com.bobocode.petros.grpcserver.configuration;

import com.devskiller.jfairy.Fairy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FairyConfiguration {
    @Bean
    public Fairy fairyPerson() {
        return Fairy.create();
    }
}
