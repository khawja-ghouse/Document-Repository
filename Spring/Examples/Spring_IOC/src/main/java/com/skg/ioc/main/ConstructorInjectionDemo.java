package com.skg.ioc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skg.ioc.services.Coach;

public class ConstructorInjectionDemo {

	public static void main(String[] args) {
		// SpringApplication.run(SpringIocApplication.class, args);

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// When we are trying to get the bean myCoach, we actually get the bean fully
		// assembled

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
