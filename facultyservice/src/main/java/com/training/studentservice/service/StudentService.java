package com.training.studentservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.studentservice.model.Student;

public interface StudentService {
	
	public List<Student> getStudents();
	public Student createStudent(Student student);
	public Student getStudentByFacultyId(long studentId);
	public boolean updateStudent(Student student);
	public boolean deleteStudentById(Long studentId);
}