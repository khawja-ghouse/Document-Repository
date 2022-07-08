package com.rwx.jms.example;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMainConsumer {

	public static void main(String[] args) {
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		JMSRouteBuilderConsumer jmsRouteBuilder = new JMSRouteBuilderConsumer();

		ProducerTemplate template = ctx.createProducerTemplate();
		try {
			ctx.addRoutes(jmsRouteBuilder);
			ctx.start();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
