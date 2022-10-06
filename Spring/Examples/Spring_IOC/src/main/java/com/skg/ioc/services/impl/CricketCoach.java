package com.skg.ioc.services.impl;

import com.skg.ioc.services.Coach;
import com.skg.ioc.services.FortuneService;

public class CricketCoach implements Coach {

	FortuneService fortuneService;

	private String emailAdderss;
	private String teamName;

	public String getEmailAdderss() {
		return emailAdderss;
	}

	public void setEmailAdderss(String emailAdderss) {
		System.out.println("Cricket Coach: inside setter method - setEmailAdderss ");
		this.emailAdderss = emailAdderss;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		System.out.println("Cricket Coach: inside setter method - setTeamName ");
		this.teamName = teamName;
	}

	public CricketCoach() {
		System.out.println("Inside No args constructor of CricketCoach ");
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method - setfortune service");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Fast bowling for 15 min";
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

}
