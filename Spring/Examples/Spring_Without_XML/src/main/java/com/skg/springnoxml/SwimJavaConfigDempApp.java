package com.skg.springnoxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skg.springdemo.services.impl.SwimCoach;

public class SwimJavaConfigDempApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		// Get the bean from spring container
		// Coach tenniesCoach = context.getBean("tenniesCoach", Coach.class);

		SwimCoach tenniesCoach = context.getBean("swimCoach", SwimCoach.class);
		// call a method on a bean
		System.out.println(tenniesCoach.getDailyWorkout());

		System.out.println(tenniesCoach.getDailyFortune());
		
		System.out.println(tenniesCoach.getEmail());
		
		System.out.println(tenniesCoach.getTeam());
		// close the context
		context.close();
	}

}
