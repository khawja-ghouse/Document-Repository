package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringBootDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataRestApplication.class, args);
	}

}
