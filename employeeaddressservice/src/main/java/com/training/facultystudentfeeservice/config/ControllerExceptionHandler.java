package com.training.facultystudentfeeservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = DataNotFoundException.class)
	public ResponseEntity<?> exception(DataNotFoundException exception) {
		return new ResponseEntity<>("ID not found in the database, please try again with the different ID",
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ServiceDownException.class)
	public ResponseEntity<?> exception(ServiceDownException exception) {
		return new ResponseEntity<>("Service down, Please try again after some time",HttpStatus.SERVICE_UNAVAILABLE);
	}

}
