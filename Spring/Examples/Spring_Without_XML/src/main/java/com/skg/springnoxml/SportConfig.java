package com.skg.springnoxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.skg.springdemo.services.Coach;
import com.skg.springdemo.services.FortuneService;
import com.skg.springdemo.services.impl.SadFortuneService;
import com.skg.springdemo.services.impl.SwimCoach;

@Configuration
@PropertySource("classpath:sports.properties")
//@ComponentScan("com.skg")
public class SportConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}

	// define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define a bean for swim coach AND Inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
