package com.departmentservice.serviceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.departmentservice.dto.DepartmentDto;
import com.departmentservice.entity.Department;
import com.departmentservice.repository.DepartmentRepository;
import com.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

	//Dependency Injection using COnstrucrtor using AllArgeConst
	
	private DepartmentRepository departmentRepository;
	
	private ModelMapper mapper;
	

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		//convert the department dto to user entity
		
		Department department= mapper.map(departmentDto, Department.class);
		
        Department saveDepartment =departmentRepository.save(department);
        
    	//convert the entity to userDto
        
        DepartmentDto departmentDto2= mapper.map(saveDepartment,DepartmentDto.class);
		
		return departmentDto2;
	}


	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
	Department department=departmentRepository.findBydepartmentCode(departmentCode);
	
	DepartmentDto departmentDto=mapper.map(department, DepartmentDto.class);
		
	return departmentDto;

	}

}
