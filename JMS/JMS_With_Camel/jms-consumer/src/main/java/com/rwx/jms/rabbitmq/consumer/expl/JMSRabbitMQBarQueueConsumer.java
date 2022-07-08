package com.rwx.jms.rabbitmq.consumer.expl;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;

public class JMSRabbitMQBarQueueConsumer {

	public static void main(String[] args) throws Exception {
		CamelContext conext = SpringCamelContext.springCamelContext("jms_rabbitMq_bar_queue_consumer.xml");
		conext.start();
		ProducerTemplate template = conext.createProducerTemplate();
		// template.sendBody("direct:start", "this is camel");

	}
}
