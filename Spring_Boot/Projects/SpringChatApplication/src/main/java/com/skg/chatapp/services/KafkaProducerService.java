package com.skg.chatapp.services;

import com.skg.chatapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
