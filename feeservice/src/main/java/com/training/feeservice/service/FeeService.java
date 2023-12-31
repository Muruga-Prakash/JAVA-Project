package com.training.feeservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.training.feeservice.model.Fee;

public interface FeeService {
	
	public List<Fee> getFees();
	public Fee createFee(Fee fee);
	public Fee getFeeByStudentId(long studentId);
	public boolean updateFee(Fee fee);
	public boolean deleteFeeByStudentId(Long studentId);
}