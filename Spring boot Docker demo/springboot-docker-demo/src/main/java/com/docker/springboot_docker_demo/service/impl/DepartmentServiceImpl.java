package com.docker.springboot_docker_demo.service.impl;


import com.docker.springboot_docker_demo.entity.Department;
import com.docker.springboot_docker_demo.repository.DepartmentRepository;
import com.docker.springboot_docker_demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department departmentDto) {
        //convert department dto to department jpa entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department saveDepartment = departmentRepository.save(department);


        return saveDepartment;
    }

    @Override
    public Department getByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return department;
    }
}
