package com.training.studentservice.controller;

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

import com.training.studentservice.config.StudentNotFoundException;
import com.training.studentservice.model.Student;
import com.training.studentservice.repository.StudentRepository;
import com.training.studentservice.service.StudentService;

@RestController
public class StudentController {

	public static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;

	

	@GetMapping(value = "/student/faculty/{facultyId}")
	public Student getStudentByFacultyId(@PathVariable long facultyId) {

		// if (!facultyRepository.existsById(courseId))
		// throw new FacultyNotFoundException();
		return studentService.getStudentByFacultyId(facultyId);
	}

	@GetMapping(value = "/students")
	public List<Student> getStudents() {
		System.out.println("I am invoked for courseId:");
		return studentService.getStudents();
	}

	@PostMapping(value = "/student")
	public Student createStudent(@RequestBody Student student) {

		LOGGER.debug("Create Student is called");

		return studentService.createStudent(student);

	}

	@PutMapping("/updatestud")
	public boolean updateStudent(@RequestBody Student student) {

		LOGGER.debug("Update Student is called");

		if (studentService.updateStudent(student)) {
			return true;

		} else {
			return false;

		}

	}

	@DeleteMapping(value = "/{studentId}")
	public boolean deleteStudentById(@PathVariable Long studentId) {
		try {
			if (studentService.deleteStudentById(studentId) == true) {
				System.out.println("shd not go inside");
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

}