package com.organization.organizationmicroservice.organizationmicroservice.controller;

import com.organization.organizationmicroservice.organizationmicroservice.entity.Organization;
import com.organization.organizationmicroservice.organizationmicroservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "OrganizationController exposes API for Organization service"
)
@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save Organization object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<Organization> saveOrganization(@RequestBody Organization organization){
        Organization savedOrganization = organizationService.saveOrganization(organization);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get Organization object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @GetMapping("{organizationCode}")
    public ResponseEntity<Organization> getOrganization(@PathVariable String organizationCode){
        Organization savedOrganization = organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(savedOrganization, HttpStatus.OK);
    }
}
