package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class SpringBootCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdApplication.class, args);
	}

}
