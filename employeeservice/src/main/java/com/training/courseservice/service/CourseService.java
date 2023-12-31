package com.training.courseservice.service;

import java.util.List;

import com.training.courseservice.model.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public Course getOnecourseById(Long courseId);
	//public Course getCourseByFeeId(long feeId);
	public Course createCourse(Course course);
	public boolean updateCourse(Course course);
	public boolean deleteCourse(Long courseId);
}
