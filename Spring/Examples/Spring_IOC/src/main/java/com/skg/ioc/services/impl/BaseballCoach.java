package com.skg.ioc.services.impl;

import com.skg.ioc.services.Coach;
import com.skg.ioc.services.FortuneService;

public class BaseballCoach implements Coach {

	FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
