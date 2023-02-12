package ru.ksimi.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(topics = "example_topic", groupId = "consumer_test_group")
    public void handleMessage(@Payload String message) {
        System.out.printf("Message was received: %s\n", message);
    }
}