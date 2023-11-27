package com.employee_service.service;

import com.employee_service.dto.ApiResponseDto;
import com.employee_service.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto getEmployeeById(Long Id);
	
}
