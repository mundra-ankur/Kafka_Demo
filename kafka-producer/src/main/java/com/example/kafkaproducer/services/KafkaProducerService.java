package com.example.kafkaproducer.services;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ankurmundra
 * May 22, 2023
 */

@Service
public class KafkaProducerService {
    public static final String TOPIC_NAME = "test-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;


    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    public void sendMessage(String key, String message) {
        System.out.println("Sending message with key: " + key + " --> " + message);
        kafkaTemplate.send(TOPIC_NAME, key, message);
    }
}
