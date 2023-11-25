package com.udspring.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.udspring.beans.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/employee")
	public ResponseEntity<Employee> getEmployee() {
		Employee employee=new Employee(
				1,"Salman","khan","Airli","Manager"			
				);
		//return new ResponseEntity<>(employee,HttpStatus.OK);
		return ResponseEntity.ok().header("baba", "baba").body(employee);
		
	}
	
	@GetMapping("/employees")
	public List<Employee> listEmployee(){
		
		List<Employee> employee=new ArrayList<>();
		employee.add(new Employee(2,"Raju","mishra","Pune","Housekeeping"));
		employee.add(new Employee(2,"Gurav","Lavand","Pune","WaterBoy"));
		
		
		return employee ;
		
	}
	
	@GetMapping("/employee/{id}/{first-name}/{last-name}/{location}/{position}")
	public Employee studentPathVariable(@PathVariable("id") int employeid,
										@PathVariable("first-name") String firstName,
										@PathVariable("last-name") String LastName,
										@PathVariable("location") String location,
										@PathVariable("position") String position){
		return new Employee(employeid,firstName,LastName,location,position);
	}
	
	@PostMapping("employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		System.out.println(employee.getId());
		return employee;
	}
	
	
	
}
