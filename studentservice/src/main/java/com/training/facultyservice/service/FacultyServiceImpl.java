package com.training.facultyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.facultyservice.model.Faculty;
import com.training.facultyservice.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	FacultyRepository facultyRepository;
	
	@Override
	public List<Faculty> getFaculties() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty createFaculty(Faculty faculty) {
		System.out.println(faculty);
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty getFacultyByCourseId(long courseId) {
		return facultyRepository.getFacultyByCourseId(courseId);
	}

	@Override
	public boolean updateFaculty(Faculty faculty) {
		if(facultyRepository.existsById((Long)faculty.getId())) {
			facultyRepository.save(faculty);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteFacultyById(Long facultyId) {
		if(facultyRepository.existsById(facultyId)) {
			
			facultyRepository.deleteById(facultyId);
			return true;
		}
		else {
			
			return false;
		}
	}

	

}