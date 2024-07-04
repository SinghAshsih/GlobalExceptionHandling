package com.asr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private Long id;
	@NotEmpty(message = "Employee name should not be empty")
	private String name;
	private int age;
	private Long salary;
	@NotEmpty(message = "Employee email should not be empty")
	@Email
	private String email;
}
