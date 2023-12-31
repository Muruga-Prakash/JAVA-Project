package com.training.facultystudentfeeservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.facultystudentfeeservice.model.Course;
import com.training.facultystudentfeeservice.model.Fee;



@FeignClient("FEESERVICE")
public interface FeeWebService {
	
	@GetMapping("/fee")
	public List<Fee> getFees();
	
	@GetMapping(value = "/{feeId}")
	public Fee getFeeById(@PathVariable(value="feeId") long feeId);
	
	@PostMapping(value = "/fee")
	public Fee createFee(@RequestBody Fee fee);
	
	@PutMapping("/updatefee")
	public boolean updateFee(@RequestBody Fee fee);
	
	@DeleteMapping(value = "/{feeId}")
	public boolean deleteFeeByStudentId(@PathVariable(value="feeId") Long feeId);

	
	
	

}
