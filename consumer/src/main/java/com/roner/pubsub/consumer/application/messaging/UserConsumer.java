package com.roner.pubsub.consumer.application.messaging;

import com.roner.pubsub.consumer.application.dto.UserRequest;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class UserConsumer {

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consume(ConsumerRecord<String, UserRequest> record) {
        log.info(String.format("Consumed message -> %s", record.value()));
    }
} 