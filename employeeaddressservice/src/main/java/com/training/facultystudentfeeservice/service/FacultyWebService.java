package com.training.facultystudentfeeservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.training.facultystudentfeeservice.model.Faculty;

@FeignClient("FACULTYSERVICE")
public interface FacultyWebService {
	
	@GetMapping("/faculty/course/{courseId}")
	public Faculty getFacultyByCourseId(@PathVariable(value = "courseId") long courseId);
	
	
	@PostMapping("/faculty")
	public Faculty addFaculty(@RequestBody Faculty faculty);
	
	@PutMapping("/updatefac")
	public boolean updateFaculty(Faculty faculty);
	
	@DeleteMapping(value = "/{facultyId}")
	public boolean deleteFacultyById(@PathVariable(value = "facultyId") Long facultyId);
}