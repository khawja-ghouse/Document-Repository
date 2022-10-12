package com.skg.springdemo.services.impl;

import org.springframework.stereotype.Component;
import com.skg.springdemo.services.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is ur lucky day";
	}

}
