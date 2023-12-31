package com.training.courseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.courseservice.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	//Course getCourseByFeeId(long feeId);
}
