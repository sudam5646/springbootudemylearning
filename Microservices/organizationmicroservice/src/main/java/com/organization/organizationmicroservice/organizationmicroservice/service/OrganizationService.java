package com.organization.organizationmicroservice.organizationmicroservice.service;

import com.organization.organizationmicroservice.organizationmicroservice.entity.Organization;

public interface OrganizationService {

    Organization saveOrganization(Organization organization);

    Organization getOrganizationByCode(String organizationCode);
}
