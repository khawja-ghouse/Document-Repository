package com.skg.springdemo.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skg.springdemo.services.Coach;
import com.skg.springdemo.services.impl.TenniesCoach;

public class SpringAnotationDemoApplication {

	public static void main(String[] args) {
		// Read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Get the bean from spring container
		// Coach tenniesCoach = context.getBean("tenniesCoach", Coach.class);

		TenniesCoach tenniesCoach = context.getBean("tenniesCoach", TenniesCoach.class);
		// call a method on a bean
		System.out.println(tenniesCoach.getDailyWorkout());

		System.out.println(tenniesCoach.getDailyFortune());
		System.out.println(tenniesCoach.getEmail());
		System.out.println(tenniesCoach.getTeam());
		// close the context
		context.close();
	}

}
