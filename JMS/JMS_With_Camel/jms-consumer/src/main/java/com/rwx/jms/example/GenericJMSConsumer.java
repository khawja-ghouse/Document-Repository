package com.rwx.jms.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONObject;

public class GenericJMSConsumer {

	static Random r = new Random();
	int high = 10;

	public static void main(String[] args) throws Exception {
		System.out.println("Inside main of Genric Consumer....");
		BasicConfigurator.configure();
		// Getting JMS connection from the server
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		Connection connection = connectionFactory.createConnection();
		connection.start();
		// Creating session for seding messages
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// Getting the queue
		Destination destination = session.createQueue("Queue.inputQueue");
		// MessageConsumer is used for receiving (consuming) messages
		MessageConsumer consumer = session.createConsumer(destination);
		
		System.out.println("After consumer createddd...");

		// Here we receive the message.
		// By default this call is blocking, which means it will wait
		// for a message to arrive on the queue.
		while (true) {
			System.out.println("Before consumer.receive()");
			Message message = consumer.receive();
			
			System.out.println("After consumer.receive()");
			// There are many types of Message and TextMessage
			// is just one of them. Producer sent us a TextMessage
			// so we must cast to it to get access to its .getText()
			// method.
			System.out.println("Message is ::" + message);
			if (message instanceof TextMessage) {
				Map<String, Object> headerMap = new HashMap();
				TextMessage textMessage = (TextMessage) message;
				System.out.println("Received message '" + textMessage.getText() + "'");

				System.out.println("Consumer Message JMSCorrelationID ::" + message.getJMSCorrelationID());
				System.out.println("Consumer Message JMSDestination ::" + message.getJMSDestination());
				System.out.println("Consumer Message JMSReplyTo ::" + message.getJMSReplyTo());
				System.out.println("Consumer Message JMSDeliveryMode ::" + message.getJMSDeliveryMode());
				System.out.println("Consumer Message JMSMessageID ::" + message.getJMSMessageID());
				System.out.println("Consumer Message JMSType ::" + message.getJMSType());

				headerMap.put("JMSCorrelationID", message.getJMSCorrelationID());
				headerMap.put("JMSDestination", message.getJMSDestination());
				headerMap.put("JMSReplyTo", message.getJMSReplyTo());

				long result;
				String requestId = null;
				System.out.println("Consumer Queue working ....");
				System.out.println("Body we consumed ..." + textMessage.getText());

				JSONObject jsonBody = new JSONObject(textMessage.getText());

				result = r.nextInt(10) * 1000;

				System.out.println("Sleeping Time ::" + result);
				System.out.println("Id ::" + jsonBody.getString("Id"));

				requestId = jsonBody.getString("Id").toString();

				Thread.currentThread().sleep(result);

				jsonBody.put("Id", requestId + " " + "complted");
				jsonBody.put("delay", result);

				headerMap.put("textMessage", jsonBody);

				Producer(headerMap, message);
			}
		}
		// exchange.getIn().setBody(jsonBody.toString());
		// System.out.println("Exchange
		// Headers::"+exchange.getIn().getHeaders());
		// connection.close();
	}

	public static void Producer(Map<String, Object> messageDetails, Message consumerMessage)
			throws JMSException, NamingException {
		try {
			// Create a ConnectionFactory
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			// Create a Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// Create the destination (Topic or Queue)
			Destination destination = session.createQueue("Queue.inputQueue");

			Destination barQueue = session.createQueue("bar");
			// Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(barQueue);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// Create a messages
			TextMessage message = session.createTextMessage(messageDetails.get("textMessage").toString());

			System.out.println("Message to send ::" + message.getText());

			System.out.println("Producer Message before setting JMSCorrelationID ::" + message.getJMSCorrelationID());
			System.out.println("Producer Message before setting JMSDestination ::" + message.getJMSDestination());
			System.out.println("Producer Message before setting JMSReplyTo ::" + message.getJMSReplyTo());

			message.setJMSCorrelationID(consumerMessage.getJMSCorrelationID());

			// message.setJMSDestination(consumerMessage.getJMSDestination());
			// message.setJMSReplyTo(consumerMessage.getJMSReplyTo());

			System.out.println("==================================================");
			System.out.println("Producer Message After setting JMSCorrelationID ::" + message.getJMSCorrelationID());
			System.out.println("Producer Message After setting JMSDestination ::" + message.getJMSDestination());
			System.out.println("Producer Message After setting JMSReplyTo ::" + message.getJMSReplyTo());

			// Tell the producer to send the message
			System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
			producer.send(message);

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}

}
