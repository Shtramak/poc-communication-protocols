package com.bobocode.petros.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

@Configuration
@EnableKafka
public class KafkaTopicConfig {

    public static final String HOTEL_REQUEST_EXAMPLE_TOPIC = "hotel-request-example";
    public static final String HOTEL_RESPONSE_EXAMPLE_TOPIC = "hotel-response-example";
    public static final String TICKET_REQUEST_EXAMPLE_TOPIC = "ticket-request-example";
    public static final String TICKET_RESPONSE_EXAMPLE_TOPIC = "ticket-response-example";

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = new HashMap<String, Object>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic hotelRequestExampleTopic() {
        return new NewTopic(HOTEL_REQUEST_EXAMPLE_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic hotelResponseExampleTopic() {
        return new NewTopic(HOTEL_RESPONSE_EXAMPLE_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic ticketRequestExampleTopic() {
        return new NewTopic(TICKET_REQUEST_EXAMPLE_TOPIC, 1, (short) 1);
    }

    @Bean
    public NewTopic ticketResponseExampleTopic() {
        return new NewTopic(TICKET_RESPONSE_EXAMPLE_TOPIC, 1, (short) 1);
    }
}
