package com.skg.springdemo.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.skg.springdemo.services.Coach;
import com.skg.springdemo.services.FortuneService;

@Component("tenniesCoach")
public class TenniesCoach implements Coach {
	
	// This is made possible by Java technology call Reflextion
	// Field injection
	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;

	public TenniesCoach() {
		System.out.println("TenniesCoach No arg Constructor ....");
	}
	
	@PostConstruct
	public void afterBeanCall() {
		System.out.println("This is after bean initialization....");
	}
	
	@PreDestroy
	public void CleanUp() {
		System.out.println("This is cleaning up process....");
	}

	// Constructor injection
//	@Autowired
//	public TenniesCoach(FortuneService fortuneService) {

//		this.fortuneService = fortuneService;
//	}

//	@Autowired
//	public TenniesCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
//
//		System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
//
//		fortuneService = theFortuneService;
//	}
	
	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backend voley";
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	// Setter injection
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("TenniesCoach :: Inside Setter FortuneService");
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

// Default bean id is class name, make first letter lower-case 
