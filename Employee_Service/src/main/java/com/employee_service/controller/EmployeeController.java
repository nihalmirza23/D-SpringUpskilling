package com.employee_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee_service.dto.ApiResponseDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.entity.Employee;
import com.employee_service.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController

@RequestMapping("/api/emp")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		  EmployeeDto employeeDto2=     employeeService.saveEmployee(employeeDto);
		  return new ResponseEntity<> (employeeDto2,HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
		ApiResponseDto apiResponseDto= employeeService.getEmployeeById(id);
		 return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
	
	
}
