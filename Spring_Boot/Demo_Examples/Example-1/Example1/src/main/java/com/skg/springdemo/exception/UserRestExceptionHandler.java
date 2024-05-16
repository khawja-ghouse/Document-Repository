package com.skg.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handelException(UserNotFoundException ex) {
		// create a userErrorResponse
		UserErrorResponse errorResponse = new UserErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<UserErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// Add exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handelException(Exception ex) {
		// create a userErrorResponse
		UserErrorResponse errorResponse = new UserErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<UserErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
