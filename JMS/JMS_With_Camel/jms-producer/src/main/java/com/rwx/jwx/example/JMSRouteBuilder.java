package com.rwx.jwx.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class JMSRouteBuilder extends RouteBuilder {

	@SuppressWarnings("deprecation")
	@Override
	public void configure() throws Exception {
		from("restlet:http://0.0.0.0:8888/getProjects?restletMethods=get,post").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("Process Reslet ...");
				System.out.println(exchange.getIn().getBody(String.class));
			}
		}).inOut().to("jms:queue:Queue.inputQueue?requestTimeout=30s&replyTo=bar&jmsMessageType=Text");
				/*.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("Producer queue...");
						System.out.println(exchange.getIn().getBody().toString());
					}
				});*/
	}
}