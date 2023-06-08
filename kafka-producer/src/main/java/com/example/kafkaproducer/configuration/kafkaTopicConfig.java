package com.example.kafkaproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author ankurmundra
 * May 22, 2023
 */

@Configuration
public class kafkaTopicConfig {
    public static final String TOPIC_NAME = "test-topic";

    @Bean
    public NewTopic createTopic() {
        TopicBuilder builder = TopicBuilder.name(TOPIC_NAME).partitions(2).replicas(1);
        return builder.build();
    }
}
