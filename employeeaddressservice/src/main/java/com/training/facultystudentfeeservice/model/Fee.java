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
public class Fee {
	
	private long id;
	@Length(min=2, max= 10)
	@Pattern(regexp="^[A-Za-z]*$",message="Field can not contain a number. Enter only characters")
	private String feeStatus;
	private float amount;
	private long studentId;

}
