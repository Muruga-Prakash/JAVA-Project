package com.training.facultyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.facultyservice.model.Faculty;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	//derived method/queries
	Faculty getFacultyByCourseId(long courseId);

}
