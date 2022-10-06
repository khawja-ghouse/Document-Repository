package com.skg.ioc.services.impl;

import com.skg.ioc.services.Coach;
import com.skg.ioc.services.FortuneService;

public class TrackCoach implements Coach {

	// Define a private field for dependency
	FortuneService fortuneService;

	// Define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// Use the fortune service to get fortune.
		return this.fortuneService.getFortune();
	}

}
