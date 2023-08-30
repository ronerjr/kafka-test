package com.roner.pubsub.consumer.infrastruture.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Value("${topic.name}")
    private String topicName;

    @Value("${topic.partitions-num}")
    private Integer partitions;

    @Value("${topic.replication-factor}")
    private short replicationFactor;

    @Bean
    NewTopic topic() {
        return new NewTopic(topicName, partitions, replicationFactor);
    }
}