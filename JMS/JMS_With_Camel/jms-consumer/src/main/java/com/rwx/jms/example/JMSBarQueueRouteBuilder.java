package com.rwx.jms.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class JMSBarQueueRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("jms:queue:bar?concurrentConsumers=20&asyncConsumer=true")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				long result;
				String requestId = null;
				System.out.println("Bar Queue consumer working ....");
				System.out.println("Body we consumed ..." + exchange.getIn().getBody(String.class));
				
				//exchange.getIn().setHeader("JMSReplyTo", "bardfsdfsd");
				exchange.getIn().setBody("Bar queue processed and completed..");
			}
		});

		
	}

}
