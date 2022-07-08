package com.rwx.jms.example;

import java.util.Random;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.json.JSONObject;

public class JMSRouteBuilderConsumer extends RouteBuilder {

	Random r = new Random();
	int high = 10;

	@Override
	public void configure() throws Exception {
		from("jms:queue:Queue.inputQueue?concurrentConsumers=20&asyncConsumer=true")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				long result;
				String requestId = null;
				System.out.println("Consumer Queue working ....");
				System.out.println("Body we consumed ..." + exchange.getIn().getBody(String.class));

				JSONObject jsonBody = new JSONObject(exchange.getIn().getBody(String.class));

				result = r.nextInt(high) * 1000;

				System.out.println("Sleeping Time ::" + result);
				System.out.println("Id ::" + jsonBody.getString("Id"));

				requestId = jsonBody.getString("Id").toString();

				Thread.currentThread().sleep(result);

				jsonBody.put("Id", requestId + " " + "complted");
				jsonBody.put("delay", result);

				exchange.getIn().setBody(jsonBody.toString());
				System.out.println("Exchange Headers::"+exchange.getIn().getHeaders());
				
				
			}
		});

	}

}
