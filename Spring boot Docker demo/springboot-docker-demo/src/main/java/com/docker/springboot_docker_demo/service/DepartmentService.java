package com.docker.springboot_docker_demo.service;

import com.docker.springboot_docker_demo.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department departmentDto);

    Department getByDepartmentCode(String departmentCode);
}
