package com.rwx.jms.example;

import java.util.Random;

import javax.jms.Message;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App implements Processor {
	Random r = new Random();

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public void process(Exchange exchange) throws InterruptedException {
		long result;
		String requestId = null;
		System.out.println("Consumer Queue working ....");
		System.out.println("Body we consumed ..." + exchange.getIn().getBody(String.class));

		JSONObject jsonBody = new JSONObject(exchange.getIn().getBody(String.class));

		result = r.nextInt(10) * 1000;

		System.out.println("Sleeping Time ::" + result);
		System.out.println("Id ::" + jsonBody.getString("Id"));

		requestId = jsonBody.getString("Id").toString();

		Thread.currentThread().sleep(result);

		jsonBody.put("Id", requestId + " " + "complted");
		jsonBody.put("delay", result);

		exchange.getIn().setBody(jsonBody.toString());
		System.out.println("Exchange Headers::" + exchange.getIn().getHeaders());

	}

	public void barQueueConsumed(Exchange exchange) {
		System.out.println("Bar Queue Consumer working ....");
		System.out.println("Body consumed ..." + exchange.getIn().getBody(String.class));
		System.out.println("Exchange Headers ::" + exchange.getIn().getHeaders());
		

	}
}
