package com.khwaja.controller;

import com.khwaja.services.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenPublisher {

    private KafkaMessagePublisher messagePublisher;

    @Autowired
    public EvenPublisher(KafkaMessagePublisher kafkaMessagePublisher){
        this.messagePublisher = kafkaMessagePublisher;
    }

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishResponse(@PathVariable String message){

        try {
            for (int i = 0; i < 10000; i++) {
                messagePublisher.sendMessageToTopic(message);
            }
            return ResponseEntity.ok("message published successfully !!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
