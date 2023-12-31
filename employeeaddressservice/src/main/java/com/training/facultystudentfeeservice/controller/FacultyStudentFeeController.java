package com.training.facultystudentfeeservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.facultystudentfeeservice.config.DataNotFoundException;
import com.training.facultystudentfeeservice.config.ServiceDownException;
import com.training.facultystudentfeeservice.model.Fee;
import com.training.facultystudentfeeservice.service.FacultyStudentFeeService;

import feign.RetryableException;

@RestController
public class FacultyStudentFeeController {

	@Autowired
	FacultyStudentFeeService facStudentfeeservice;

	@GetMapping("/fees")
	public List<Fee> getFees() {
		return facStudentfeeservice.getFees();
	}

	@GetMapping(value = "/{FeeId}")
	public Fee getFeeById(@PathVariable(value = "FeeId") Long FeeId) {
		try {
			return facStudentfeeservice.getFeeById(FeeId);
		}
		catch(feign.FeignException e) {
			throw new DataNotFoundException();
		}
		
		
	}

	@PostMapping("/student")
	public ResponseEntity createStudent(@Valid @RequestBody Fee Fee, BindingResult result) {

		Map<String, String> errors = new HashMap<String, String>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});

			// LOGGER.info("Error occurred in the request body:" + errors);
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(facStudentfeeservice.addFeeStudent(Fee), HttpStatus.CREATED);
	}

	@PutMapping("/")
	public ResponseEntity<?> updateStudent(@Valid @RequestBody Fee Fee, BindingResult result) {

		Map<String, String> errors = new HashMap<String, String>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach((error) -> {
				String fieldName = ((FieldError) error).getField();
				String message = error.getDefaultMessage();
				errors.put(fieldName, message);
			});

			//LOGGER.info("Error occurred in the request body:" + errors);
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		else if(facStudentfeeservice.updateFeeStudent(Fee) == true) {
		   return new ResponseEntity<>("Details updated successfully", HttpStatus.CREATED);
		}
		else {
			throw new DataNotFoundException();
		}
	


	}

	@DeleteMapping(value = "/{studentId}")
	public String deleteStudentById(@PathVariable(value = "studentId") Long studentId) {
		try {
			if (facStudentfeeservice.deleteStudentById(studentId)== true) {
				return "Deleted Successfully";
			}
			else {
				return "ID Not Found in Databse, Try again with different ID";
			}
		} catch (feign.RetryableException e) {
			throw new ServiceDownException();
		}
		
	}

}