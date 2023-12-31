package com.training.facultyservice.controller;

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

import com.training.facultyservice.config.FacultyNotFoundException;
import com.training.facultyservice.model.Faculty;
import com.training.facultyservice.repository.FacultyRepository;
import com.training.facultyservice.service.FacultyService;

@RestController
public class FacultyController {

	public static final Logger LOGGER = LoggerFactory.getLogger(FacultyController.class);

	@Autowired
	FacultyService facultyService;

	@Autowired
	private FacultyRepository facultyRepository;

	@GetMapping(value = "/faculty/course/{courseId}")
	public Faculty getFacultyByCourseId(@PathVariable long courseId) {

		// if (!facultyRepository.existsById(courseId))
		// throw new FacultyNotFoundException();
		return facultyService.getFacultyByCourseId(courseId);
	}

	@GetMapping(value = "/faculties")
	public List<Faculty> getFaculties() {
		System.out.println("I am invoked for courseId:");
		return facultyService.getFaculties();
	}

	@PostMapping(value = "/faculty")
	public Faculty createFaculty(@RequestBody Faculty faculty) {

		LOGGER.debug("Create Faculty is called");

		return facultyService.createFaculty(faculty);

	}

	@PutMapping("/updatefac")
	public boolean updateFaculty(@RequestBody Faculty faculty) {

		LOGGER.debug("Update Faculty is called");

		if (facultyService.updateFaculty(faculty)== true) {
			return true;

		} else {
			return false;

		}

	}

	@DeleteMapping(value = "/{facultyId}")
	public boolean deleteFacultyById(@PathVariable Long facultyId) {
		try {
			if (facultyService.deleteFacultyById(facultyId) == true) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}