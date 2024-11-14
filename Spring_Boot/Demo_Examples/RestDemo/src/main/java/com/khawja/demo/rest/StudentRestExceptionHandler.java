package com.khawja.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.khawja.demo.model.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(e.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e) {

		// create a StudentErrorResponse object

		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage("Unable to find student");
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());

		// return a response entity
		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
}
