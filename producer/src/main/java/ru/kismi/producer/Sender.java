package ru.kismi.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Sender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/sendMessage/topic/{topicName}/message/{message}")
    public void sendMessage(@PathVariable String topicName, @PathVariable String message) {
        kafkaTemplate.send(topicName, message)
                .thenAccept((res) -> System.out.println("Message was sent"))
                .exceptionally(ex -> {
                    System.out.println("Oops! We have an exception - " + ex.getMessage());
                    return null;
                });

    }
}