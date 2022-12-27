package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luv2code.springdemo.exception.CustomerNotFoundException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	private ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
		// Create a Custom Error Response
		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(customerErrorResponse, HttpStatus.NOT_FOUND);
	}

	// Add another exception handlers for other exceptions
	@ExceptionHandler
	private ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {
		// Create a Custom Error Response
		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(customerErrorResponse, HttpStatus.BAD_REQUEST);
	}
}
