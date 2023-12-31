package com.training.facultystudentfeeservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.facultystudentfeeservice.model.Fee;

public interface FacultyStudentFeeService {

	public List<Fee> getFees();
	public Fee addFeeStudent(Fee Fee);
	public boolean updateFeeStudent(Fee Fee);
	public boolean deleteStudentById(Long facultyId);
	//public Fee getFeeById(Long studentId);
	public Fee getOneFeeById(Long feeId);
	public Fee getFeeById(Long feeId);
}