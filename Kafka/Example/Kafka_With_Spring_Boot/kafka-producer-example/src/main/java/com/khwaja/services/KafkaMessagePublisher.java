package com.khwaja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    private KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    public KafkaMessagePublisher(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> feature = kafkaTemplate.send("NewTopic", message);
        feature.whenComplete(((result, throwable) -> {
            if (throwable == null){
                System.out.println("Sent Message [ "+message + "] with offset = [ "+
                        result.getRecordMetadata().offset() + "]" );
            }else {
                System.out.println("Unable to send Message [ "+message + "] due to "+
                        throwable.getMessage() );
            }
        }));

    }

 }
