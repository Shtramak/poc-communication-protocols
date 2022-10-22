package com.bobocode.petros.controller;

import com.bobocode.petros.producer.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kafka")
public class KafkaController {

    private final ProducerService producerService;

    @PostMapping
    public void sendMessage(@RequestBody final Payload payload) {
        this.producerService.sendMessage(payload.topic, payload.message);
    }

    record Payload(String topic, String message) {}
}
