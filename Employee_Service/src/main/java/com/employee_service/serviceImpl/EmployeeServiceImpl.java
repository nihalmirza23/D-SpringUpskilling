package com.employee_service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee_service.dto.ApiResponseDto;
import com.employee_service.dto.DepartmentDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.dto.OrganizationDto;
import com.employee_service.entity.Employee;
import com.employee_service.repository.EmployeeRepository;
import com.employee_service.service.APIClient;
import com.employee_service.service.EmployeeService;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	private APIClient apiClient;
	
	private ModelMapper mapper;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
	Employee employee=	mapper.map(employeeDto, Employee.class);
		
	Employee saveEmployee = employeeRepository.save(employee);
	
	EmployeeDto employeeDto2 = mapper.map(saveEmployee, EmployeeDto.class);
	
	return employeeDto2;
	
	}

	//@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaulDepartment")
	@Retry(name ="${spring.application.name}")
	@Override
	public ApiResponseDto getEmployeeById(Long Id) {
		
	/*
	 * Why get then findById meathod returns optional thats why we use.get()
	 */
	Employee employee=	   employeeRepository.findById(Id).get();
	
	/*
	 * URL and Response Type and gerForeNTITY RErurn Response Entity so store in response enti
	 */
	
//	  ResponseEntity<DepartmentDto>  responseEntity =    restTemplate.getForEntity("http://localhost:8080/api/getByCode/"+ employee.getDepartmentCode(),DepartmentDto.class );
//	
//	  DepartmentDto departmentDto =responseEntity.getBody();
	
	DepartmentDto departmentDto = webClient.get()
			.uri("http://localhost:8080/api/depart/getByCode/"+ employee.getDepartmentCode())
			.retrieve()
			.bodyToMono(DepartmentDto.class)
			.block();
	
	System.out.println(employee.getDepartmentCode());
	//DepartmentDto departmentDto= apiClient.getDepartmentByCode(employee.getDepartmentCode());
	
	
	OrganizationDto organizationDto= webClient.get()
									.uri("http://localhost:8084/api/organizations/"+ employee.getOrganizationCode())
									.retrieve()
									.bodyToMono(OrganizationDto.class)
									.block();
									
									
	  
	  EmployeeDto employeeDto=      mapper.map(employee, EmployeeDto.class);
	  
	  //ApiResponseDto apiResponseDto=  mapper.map(departmentDto, ApiResponseDto.class);
	  
	  ApiResponseDto apiResponseDto=new ApiResponseDto();
	  apiResponseDto.setDepartment(departmentDto);
	  apiResponseDto.setEmployee(employeeDto);
	  apiResponseDto.setOrganization(organizationDto);
		
		
		return apiResponseDto;
	}
	
	public ApiResponseDto getDefaulDepartment(Long Id, Exception exception) {
		
	     LOGGER.info("inside getDefaultDepartment() method");
		
		Employee employee=	   employeeRepository.findById(Id).get();
		
		DepartmentDto departmentDto=new DepartmentDto();
		departmentDto.setDepartmentName("R&D Depart");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Reservh and Devlopenet");
			
			  
			  EmployeeDto employeeDto=      mapper.map(employee, EmployeeDto.class);
			  
			  //ApiResponseDto apiResponseDto=  mapper.map(departmentDto, ApiResponseDto.class);
			  
			  ApiResponseDto apiResponseDto=new ApiResponseDto();
			  apiResponseDto.setDepartment(departmentDto);
			  apiResponseDto.setEmployee(employeeDto);
				
				
				return apiResponseDto;

		
		
	}
	

	

	
}
