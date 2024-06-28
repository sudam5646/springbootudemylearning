package com.organization.organizationmicroservice.organizationmicroservice.service.impl;

import com.organization.organizationmicroservice.organizationmicroservice.entity.Organization;
import com.organization.organizationmicroservice.organizationmicroservice.repository.OrganizaionRepository;
import com.organization.organizationmicroservice.organizationmicroservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizaionRepository organizaionRepository;
    @Override
    public Organization saveOrganization(Organization organization) {
        Organization savedOrganization = organizaionRepository.save(organization);
        return savedOrganization;
    }

    @Override
    public Organization getOrganizationByCode(String organizationCode) {
        Organization organization = organizaionRepository.getByOrganizationCode(organizationCode);
        return organization;
    }
}
