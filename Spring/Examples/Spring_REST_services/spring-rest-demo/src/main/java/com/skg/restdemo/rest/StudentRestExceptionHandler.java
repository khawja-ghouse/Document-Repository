package com.skg.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.skg.restdemo.exception.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// Add exception handling code
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelException(StudentNotFoundException studentNotFoundException) {

		// create a student error response
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(studentNotFoundException.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Adding a generic exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handelException(Exception exception) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
