package com.rwx.jwx.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;

public class JMSQueueProducer {

	public static void main(String[] args) throws Exception {
		CamelContext conext = SpringCamelContext.springCamelContext("jms_queue_producer.xml");
		conext.start();
		//ProducerTemplate template = conext.createProducerTemplate();
		// template.sendBody("direct:start", "this is camel");

	}
}
