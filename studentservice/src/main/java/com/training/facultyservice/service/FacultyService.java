package com.training.facultyservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.facultyservice.model.Faculty;

public interface FacultyService {
	
	public List<Faculty> getFaculties();
	public Faculty createFaculty(Faculty faculty);
	public Faculty getFacultyByCourseId(long courseId);
	public boolean updateFaculty(Faculty faculty);
	public boolean deleteFacultyById(Long facultyId);
}