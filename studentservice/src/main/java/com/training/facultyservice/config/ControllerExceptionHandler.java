package com.training.facultyservice.config;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = { JDBCConnectionException.class })
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		return new ResponseEntity<String>("Database is down, please try again after some time", HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = FacultyNotFoundException.class)
	   public ResponseEntity<?> exception(FacultyNotFoundException exception) {
	      return new ResponseEntity<>("Faculty not found in the databsae, please try again with the different FacultyId", HttpStatus.NOT_FOUND);
	   }
	
}
