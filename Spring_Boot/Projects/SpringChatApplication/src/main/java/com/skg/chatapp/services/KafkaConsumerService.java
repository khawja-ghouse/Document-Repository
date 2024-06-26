package com.skg.chatapp.services;

import com.skg.chatapp.model.Message;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerService {

    @KafkaListener(topics = "chat-messages", groupId = "chat-group")
    public void listen(Message message) {
        // Handle received message
    }
}
