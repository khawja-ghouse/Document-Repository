package com.rwx.jms.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;

public class JMSConsumer {

	public static void main(String[] args) throws Exception {
		CamelContext conext = SpringCamelContext.springCamelContext("jms_queue_consumer.xml");
		conext.start();
		ProducerTemplate template = conext.createProducerTemplate();
		// template.sendBody("direct:start", "this is camel");

	}
}
