package com.bobocode.petros.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static com.bobocode.petros.config.KafkaTopicConfig.*;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @KafkaListener(
            topics = {
                    HOTEL_REQUEST_EXAMPLE_TOPIC,
                    HOTEL_RESPONSE_EXAMPLE_TOPIC,
                    TICKET_REQUEST_EXAMPLE_TOPIC,
                    TICKET_RESPONSE_EXAMPLE_TOPIC
            }
    )
    @Override
    public void processMessage(@Payload String message) {
        System.out.println("Received message: " + message);
    }
}
