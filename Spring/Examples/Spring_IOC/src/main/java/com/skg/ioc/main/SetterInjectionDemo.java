package com.skg.ioc.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skg.ioc.services.Coach;
import com.skg.ioc.services.impl.CricketCoach;

public class SetterInjectionDemo {

	public static void main(String args[]) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		// Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// When we are trying to get the bean myCoach, we actually get the bean fully
		// assembled

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());

		System.out.println(theCoach.getEmailAdderss());

		System.out.println(theCoach.getTeamName());

		// close the context
		context.close();
	}

}
