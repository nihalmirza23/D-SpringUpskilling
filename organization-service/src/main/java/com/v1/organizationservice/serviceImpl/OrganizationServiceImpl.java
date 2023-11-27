package com.v1.organizationservice.serviceImpl;

import com.v1.organizationservice.dto.OrganizationDto;
import com.v1.organizationservice.entity.Organization;
import com.v1.organizationservice.exception.ResourceNotFoundException;
import com.v1.organizationservice.mapper.OrganizationMapper;
import com.v1.organizationservice.repo.OrganizationRepository;
import com.v1.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        // convert OrganizationDto into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode).orElseThrow(
                () -> new ResourceNotFoundException("Organization","organizationCode",organizationCode)
        );
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}