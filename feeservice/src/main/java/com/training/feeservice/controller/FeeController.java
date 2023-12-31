package com.training.feeservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

import com.training.feeservice.config.FeeNotFoundException;
import com.training.feeservice.model.Fee;
import com.training.feeservice.repository.FeeRepository;
import com.training.feeservice.service.FeeService;

@RestController
public class FeeController {

	public static final Logger LOGGER = LoggerFactory.getLogger(FeeController.class);

	@Autowired
	FeeService feeService;

	

	@GetMapping(value = "/fee/student/{studentId}")
	public Fee getFeeByStudentId(@PathVariable long studentId) {

		// if (!facultyRepository.existsById(courseId))
		// throw new FacultyNotFoundException();
		return feeService.getFeeByStudentId(studentId);
	}

	@GetMapping(value = "/fees")
	public List<Fee> getFees() {
		System.out.println("I am invoked for courseId:");
		return feeService.getFees();
	}

	@PostMapping(value = "/fee")
	public Fee createFee(@RequestBody Fee fee) {

		LOGGER.debug("Create Faculty is called");

		return feeService.createFee(fee);

	}

	@PutMapping("/updatefee")
	public boolean updateFee(@RequestBody Fee fee) {

		LOGGER.debug("Update Faculty is called");

		if (feeService.updateFee(fee)) {
			return true;

		} else {
			return false;

		}

	}

	@DeleteMapping(value = "/{feeId}")
	public boolean deleteFeeByStudentId(@PathVariable Long feeId) {
		try {
			if (feeService.deleteFeeByStudentId(feeId) == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}