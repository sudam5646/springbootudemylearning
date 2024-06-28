package com.organization.organizationmicroservice.organizationmicroservice.repository;

import com.organization.organizationmicroservice.organizationmicroservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizaionRepository extends JpaRepository<Organization, Long> {
    Organization getByOrganizationCode(String organizationCode);
}
