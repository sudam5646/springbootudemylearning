package com.employee.employeemicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private Employee employee;
    private DepartmentDto departmentDto;
    private OrganizationDto organizationDto;
}
