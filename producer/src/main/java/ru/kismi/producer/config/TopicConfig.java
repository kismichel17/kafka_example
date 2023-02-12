package ru.kismi.producer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.Map;

@Configuration
public class TopicConfig {

    @Bean
    public KafkaAdmin kafkaAdmin(@Value("${spring.kafka.bootstrap-servers}") String bootstrapAddress) {
        return new KafkaAdmin(Map.of(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress
        ));
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("example_topic", 1, (short) 1);
    }
}