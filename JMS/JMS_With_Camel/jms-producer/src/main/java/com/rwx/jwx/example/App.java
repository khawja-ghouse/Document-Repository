package com.rwx.jwx.example;

import org.apache.camel.Exchange;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public void replayedMessage(Exchange exchange) {
		System.out.println("Inside Producer queue");
		System.out.println("Exchange body is ::" + exchange.getIn().getBody(String.class));
		
	}
	
	
}
