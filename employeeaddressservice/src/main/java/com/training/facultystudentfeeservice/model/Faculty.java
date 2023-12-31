package com.training.facultystudentfeeservice.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

//import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

	private long id;
	@Length(min=2, max= 20)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String facultyName;
	@Length(min=1, max= 15)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String facultyDept;
	private long studentId;
	

}
