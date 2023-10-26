package com.skg.rest.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skg.AppConfig;

public class Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
