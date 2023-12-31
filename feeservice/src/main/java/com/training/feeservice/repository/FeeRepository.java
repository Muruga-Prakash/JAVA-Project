package com.training.feeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.feeservice.model.Fee;
@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
	//derived method/queries
	Fee getFeeByStudentId(long studentId);

}
