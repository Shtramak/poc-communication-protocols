package com.bobocode.petros.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.bobocode.petros.config.KafkaTopicConfig.HOTEL_REQUEST_EXAMPLE_TOPIC;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(final String topic, final String message) {
        Objects.requireNonNull(message, "Parameter [message] must not be null!");
        this.kafkaTemplate.send(HOTEL_REQUEST_EXAMPLE_TOPIC, message);
    }
}
