package com.skg.chatapp.controller;

import com.skg.chatapp.model.Message;
import com.skg.chatapp.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        kafkaProducerService.sendMessage("chat-messages", message);
        return message;
    }
}
