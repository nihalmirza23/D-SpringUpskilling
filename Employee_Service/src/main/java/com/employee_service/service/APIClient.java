package com.employee_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.employee_service.dto.DepartmentDto;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("/api/depart/getByCode/{id}")
	DepartmentDto getDepartmentByCode(@PathVariable("id")  String departmentCode);
}
