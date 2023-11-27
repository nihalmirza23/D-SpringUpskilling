package com.organization_server.serviceImpl;

import org.springframework.stereotype.Service;

import com.organization_server.dto.OrganizationDto;
import com.organization_server.repository.OrganizationRepository;
import com.organization_server.service.OrganizationService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class OrganizationImpl implements OrganizationService {
	
	private OrganizationRepository organizationRepository;
	
	

	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		// TODO Auto-generated method stub
		
		// convert OrganizationDto into Organization jpa entity
		
		
		
		return null;
	}

	
	
	
}
