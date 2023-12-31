package com.training.facultystudentfeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.facultystudentfeeservice.model.Student;



@FeignClient("STUDENTSERVICE")
public interface StudentWebService {
	
	@GetMapping(value = "/student/faculty/{facultyId}")
	public Student getStudentByFacultyId(@PathVariable(value="facultyId") long facultyId);
	
	@PostMapping(value = "/student")
	public Student createStudent(@RequestBody Student student);
	
	@PutMapping("/updatestud")
	public boolean updateStudent(@RequestBody Student student);
	
	@DeleteMapping(value = "/{studentId}")
	public boolean deleteStudentById(@PathVariable(value="studentId") Long studentId);

}
