package com.skg.springdemo.services.impl;

import com.skg.springdemo.services.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a sad day !!";
	}

}
