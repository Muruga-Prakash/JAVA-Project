package com.training.facultystudentfeeservice.model;

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
public class Student {
	
	private long studentId;
	@Length(min=2, max= 20)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String studFirstName;
	@Length(min=1, max= 10)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String studLastName;
	@Length(min=2, max= 10)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String feesStatus;
	private long facultyId;
	
	

}
