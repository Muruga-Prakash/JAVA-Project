package com.training.facultystudentfeeservice.model;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private long courseId;
	@Length(min=2, max= 20)
	@Pattern(regexp="^[A-Za-z]*$",message="Enter only charcters")
	private String courseName;
	private long courseDurationInMonths;
	@Valid
	private Faculty faculty;
	@Valid
	private Student student;
	@Valid
	private Fee fee;

}
