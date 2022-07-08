package com.rwx.jms.rabbitmq.example;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;

public class JMSRabbitMqQueueProducer {

	public static void main(String[] args) throws Exception {
		
		// JMS RabbitMQ Queue, Producer 
		CamelContext conext = SpringCamelContext.springCamelContext("jms_rabbitmq_queue_producer.xml");
		conext.start();
		
		// We have the consumer in project jms-consumer
		

	}
}
