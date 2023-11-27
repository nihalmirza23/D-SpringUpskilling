package com.organization_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization_server.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{

	
}
