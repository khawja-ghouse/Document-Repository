package com.rwx.jwx.example;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelMain {

	public static void main(String[] args) {
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		JMSRouteBuilder jmsRouteBuilder = new JMSRouteBuilder();
		ProducerTemplate template = ctx.createProducerTemplate();
		try {
			ctx.addRoutes(jmsRouteBuilder);
			ctx.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
