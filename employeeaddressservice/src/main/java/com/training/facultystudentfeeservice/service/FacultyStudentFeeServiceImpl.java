package com.training.facultystudentfeeservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.training.facultystudentfeeservice.config.DataNotFoundException;
import com.training.facultystudentfeeservice.config.ServiceDownException;
import com.training.facultystudentfeeservice.model.Course;
import com.training.facultystudentfeeservice.model.Faculty;
import com.training.facultystudentfeeservice.model.Fee;
import com.training.facultystudentfeeservice.model.Student;

@Service
public class FacultyStudentFeeServiceImpl implements FacultyStudentFeeService {

	@Autowired
	FeeWebService feeWebService;
	
	@Autowired
	CourseWebService courseWebSevice;

	@Autowired
	FacultyWebService facultyWebService;

	@Autowired
	StudentWebService studentWebService;

	

	/*
	 * GET method for three services
	 */
	@HystrixCommand(fallbackMethod = "defaultFee")
	public List<Fee> getFee() {
		List<Fee> feeList = feeWebSevice.getFees();
		System.out.println(feeList);

		for (Fee fee : feeList) {
			fee.setFaculty(facultyWebService.getFacultyByCourseId(fee.getFeeId()));
			fee.setStudent(studentWebService.getStudentByFacultyId(fee.getFeeId()));
			fee.setFee(feeWebService.getFeeByStudentId(fee.getFeeId()));
		}
		return feeList;
	}

	/*
	 * Fallback method
	 */
	public List<Course> defaultCourse() {

		List<Course> course = new ArrayList<Course>();

		course.add(Course.builder().courseId(-1).courseName("default")
				.faculty(Faculty.builder().id(-1).facultyName("HCL Faculty").facultyDept("HCL").courseId(-1).build())
				.build());
		return course;
	}
	

	/*
	 * GET method by Id for three
	 */
	//@HystrixCommand(fallbackMethod = "defaultSingleCourse"
	public Course getCourseById(Long courseId) {
		try {
		Course course = feeWebSevice.getOnecourseById(courseId);

		course.setFaculty(facultyWebService.getFacultyByCourseId(course.getCourseId()));
		course.setStudent(studentWebService.getStudentByFacultyId(course.getCourseId()));
		course.setFee(feeWebService.getFeeByStudentId(course.getCourseId()));
		return course;}
		catch(feign.RetryableException e) {
			throw new ServiceDownException();
		}

	}
	

	/*
	 * POST method for three services
	 */
	public Course addCourseFaculty(Course course) {
		try {

		courseWebSevice.createCourse(course);
		course.setFaculty(facultyWebService.addFaculty(course.getFaculty()));
		course.setStudent(studentWebService.createStudent(course.getStudent()));
		course.setFee(feeWebService.createFee(course.getFee()));
		return course;
		}catch(feign.RetryableException e) {
			throw new ServiceDownException();
		}
	}

	/*
	 * PUT method for three services
	 */
	public boolean updateCourseFaculty(Course course) {
		try {
			if (courseWebSevice.updateCourse(course) == facultyWebService
					.updateFaculty(course.getFaculty()) == studentWebService.updateStudent(course.getStudent())){
				if(feeWebService.updateFee(course.getFee())==true) {
				return true;
				}
				return false;
	
			} else {
				return false;
	
			}
		}catch(feign.RetryableException e) {
			throw new ServiceDownException();
		}
	}

	/*
	 * DELETE method for both services
	 */
	public boolean deleteFacultyById(Long facultyId) {

		try {

			if (studentWebService.deleteStudentById(facultyId) == courseWebSevice
					.deleteCourseById(facultyId) == facultyWebService.deleteFacultyById(facultyId)) {
				
				if(feeWebService.deleteFeeByStudentId(facultyId)==true) {
					return true;
					}
					return false;
			} else {
				return false;
			}

		} catch (feign.RetryableException e) {
			throw new ServiceDownException();
		}

	}

}