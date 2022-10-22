package com.bobocode.petros.producer;

public interface ProducerService {

    void sendMessage(final String topic, final String message);

}
