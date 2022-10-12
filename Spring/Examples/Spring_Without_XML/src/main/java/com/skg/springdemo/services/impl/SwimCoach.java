package com.skg.springdemo.services.impl;

import org.springframework.beans.factory.annotation.Value;

import com.skg.springdemo.services.Coach;
import com.skg.springdemo.services.FortuneService;

public class SwimCoach implements Coach {

	FortuneService fortuneService;

	@Value("$foo.email")
	private String email;

	@Value("$foo.team")
	private String team;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000meters as a warm up !!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
