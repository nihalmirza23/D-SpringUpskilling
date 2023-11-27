package com.employee_service.dto;

import com.employee_service.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
	private String organizationCode;
}
