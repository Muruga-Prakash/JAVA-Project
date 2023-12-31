package com.training.feeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.feeservice.model.Fee;
import com.training.feeservice.repository.FeeRepository;

@Service
public class FeeServiceImpl implements FeeService {

	@Autowired
	FeeRepository feeRepository;
	
	@Override
	public List<Fee> getFees() {
		return feeRepository.findAll();
	}

	@Override
	public Fee createFee(Fee fee) {
		System.out.println(fee);
		return feeRepository.save(fee);
	}

	@Override
	public Fee getFeeByStudentId(long studentId) {
		return feeRepository.getFeeByStudentId(studentId);
	}

	@Override
	public boolean updateFee(Fee fee) {
		if(feeRepository.existsById((Long)fee.getId())) {
			feeRepository.save(fee);
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean deleteFeeByStudentId(Long studentId) {
		if(feeRepository.existsById(studentId)) {
			
			feeRepository.deleteById(studentId);
			return true;
		}
		else {
			
			return false;
		}
	}

	

}