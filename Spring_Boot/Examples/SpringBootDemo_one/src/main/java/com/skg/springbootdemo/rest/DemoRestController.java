package com.skg.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is "+ LocalDateTime.now();
	}
}
