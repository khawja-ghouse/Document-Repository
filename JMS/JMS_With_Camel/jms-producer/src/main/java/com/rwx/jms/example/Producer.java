package com.rwx.jms.example;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import com.rwx.jwx.example.JMSRouteBuilder;

public class Producer {


    public static void main(String[] args) {
		CamelContext ctx = new DefaultCamelContext();
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		ctx.addComponent("jmsComponent", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

		JMSRouteBuilder jmsRouteBuilder = new JMSRouteBuilder();
		ProducerTemplate template = ctx.createProducerTemplate();
		try {
			ctx.addRoutes(jmsRouteBuilder);
			ctx.start();

			for (int i = 0; i < 10; i++) {
				template.sendBody("jmsComponent:queue:inputqueue", "Test Message: " + i);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
