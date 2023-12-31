package com.training.studentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.studentservice.model.Student;
import com.training.studentservice.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		System.out.println(student);
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentByFacultyId(long studentId) {
		return studentRepository.getStudentByFacultyId(studentId);
	}

	@Override
	public boolean updateStudent(Student student) {
		if(studentRepository.existsById((Long)student.getStudentId())) {
			studentRepository.save(student);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteStudentById(Long studentId) {
		
		if(studentRepository.existsById(studentId)) {
			
			studentRepository.deleteById(studentId);
			return true;
		}
		else {
			
			return false;
		}
		
		
	}

	

}