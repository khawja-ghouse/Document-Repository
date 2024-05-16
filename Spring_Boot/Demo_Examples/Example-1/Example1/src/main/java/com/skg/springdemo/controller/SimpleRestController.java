package com.skg.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skg.springdemo.exception.UserErrorResponse;
import com.skg.springdemo.exception.UserNotFoundException;
import com.skg.springdemo.model.User;
import com.skg.springdemo.service.UserService;

@RestController
@RequestMapping("chitFund")
public class SimpleRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to chit fund application !!";
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getUserById/{userId}")
	public User getUserByID(@PathVariable long userId) {
		if (userService.getUserById(userId) == null) {
			throw new UserNotFoundException("User Id not found - " + userId);
		}
		return userService.getUserById(userId);
	}

	// Add exception handler using @ExceptionHandler
//	@ExceptionHandler
//	public ResponseEntity<UserErrorResponse> handelException(UserNotFoundException ex) {
//		// create a userErrorResponse
//		UserErrorResponse errorResponse = new UserErrorResponse();
//		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
//		errorResponse.setMessage(ex.getMessage());
//		errorResponse.setTimeStamp(System.currentTimeMillis());
//
//		// return ResponseEntity
//		return new ResponseEntity<UserErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
//	}
//
//	// Add exception handler using @ExceptionHandler
//	@ExceptionHandler
//	public ResponseEntity<UserErrorResponse> handelException(Exception ex) {
//		// create a userErrorResponse
//		UserErrorResponse errorResponse = new UserErrorResponse();
//		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
//		errorResponse.setMessage(ex.getMessage());
//		errorResponse.setTimeStamp(System.currentTimeMillis());
//
//		// return ResponseEntity
//		return new ResponseEntity<UserErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//	}

}
