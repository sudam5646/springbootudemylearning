package com.department.departmentmicroservice.service.impl;

import com.department.departmentmicroservice.dto.DepartmentDto;
import com.department.departmentmicroservice.entity.Department;
import com.department.departmentmicroservice.repository.DepartmentRepository;
import com.department.departmentmicroservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert department dto to department jpa entity

        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        DepartmentDto getDepartmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return getDepartmentDto;
    }
}
