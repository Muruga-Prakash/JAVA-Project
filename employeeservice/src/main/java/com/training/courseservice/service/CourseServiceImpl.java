package com.training.courseservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.courseservice.model.Course;
import com.training.courseservice.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getOnecourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(new Course());
	}

	// @Override
	// public Course getCourseByFeeId(long feeId) {
	// return feeRepository.getCourseByFeeId(feeId);
	// }

	@Override
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public boolean updateCourse(Course course) {
		if(courseRepository.existsById((Long)course.getCourseId())) {
			courseRepository.save(course);
			return true;
		}
		else {
			return false;
		}
		
	}

	public boolean deleteCourse(Long courseId) {
		if (courseRepository.existsById(courseId)) {

			courseRepository.deleteById(courseId);
			return true;
		} else {

			return false;
		}
	}

}
