package com.khawja.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "NewTopic",groupId = "my-kraft-group")
    public void consume(String message){
        logger.info("Consumer consumes message {}", message);
    }
}
