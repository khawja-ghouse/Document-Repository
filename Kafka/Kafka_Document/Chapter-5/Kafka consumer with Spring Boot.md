
This a smile class designed for consuming messages or events.
```java
package com.khawja.kafkademo.consumer;  
  
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
```

`2024-11-20T23:03:13.589+05:30  INFO 25296 --- [kafka-consumer-example] [ntainer#0-0-C-1] o.s.k.l.KafkaMessageListenerContainer    : my-kraft-group: partitions assigned: [NewTopic-0, NewTopic-1, NewTopic-2]`

`2024-11-20T23:04:25.539+05:30  INFO 25296 --- [kafka-consumer-example] [ntainer#0-0-C-1] c.khawja.consumer.KafkaMessageListener   : Consumer consumes message Message one sent`
### Explanation:

1. **`@KafkaListener`**:
    
    - This annotation designates the `consume` method as a Kafka message listener.
    - It specifies the topic **"NewTopic"** and consumer group **"my-kraft-group"**. Messages from this topic are processed by this group.
2. **`consume` Method**:
    
    - The method is triggered whenever a new message arrives on the specified topic.
    - The message is passed as a `String` and logged using SLF4J's `Logger`.
3. **Consumer Group**:
    
    - The `groupId` ensures that multiple consumers in the same group share the workload for a topic's partitions, avoiding duplication of message processing.
4. **Logging**:
    
    - The `Logger` logs each consumed message for monitoring and debugging purposes.