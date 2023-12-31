package com.training.courseservice.controller;

import java.util.ArrayList;
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
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.courseservice.config.CourseNotFoundException;
import com.training.courseservice.model.Course;
import com.training.courseservice.repository.CourseRepository;
import com.training.courseservice.service.CourseService;

@RestController
public class CourseController {
	public static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	CourseService courseService;

	@Autowired
	private CourseRepository courseRepository;

	@GetMapping(value = "/courses")
	public List<Course> getAllCourses() {
		LOGGER.debug("Get All course is called inside CourseController");
		return courseService.getAllCourses();
	}

	@GetMapping(value = "/{courseId}") // course/courseId
	public Course getOnecourseById(@PathVariable Long courseId) {
		if (!courseRepository.existsById(courseId))
			throw new CourseNotFoundException();
		return courseService.getOnecourseById(courseId);
	}

	@PostMapping(value = "/course")
	public Course createCourse(@RequestBody Course course) {

		return courseService.createCourse(course);
	}

	@PutMapping("/course")
	public boolean updateCourse(@RequestBody Course course) {

		if (courseService.updateCourse(course) == true) {
			return true;

		} else {
			return false;

		}

	}

	@DeleteMapping(value = "/{courseId}") // course/courseId
	public boolean deleteCourseById(@PathVariable Long courseId) {
		try {
			if (courseService.deleteCourse(courseId) == true) {

				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}