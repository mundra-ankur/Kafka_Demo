package com.example.kafkaconsumer2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author ankurmundra
 * May 22, 2023
 */
@Service
public class KafkaConsumerService {
    private final String TOPIC = "test-topic";

    @KafkaListener(topics = TOPIC, groupId = "default-group")
    public void consume(String message) {
        System.out.println("Consumed message by consumer 2: " + message);
    }
}
