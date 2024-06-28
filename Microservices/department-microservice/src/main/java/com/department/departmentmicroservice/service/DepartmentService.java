package com.department.departmentmicroservice.service;

import com.department.departmentmicroservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getByDepartmentCode(String departmentCode);
}
