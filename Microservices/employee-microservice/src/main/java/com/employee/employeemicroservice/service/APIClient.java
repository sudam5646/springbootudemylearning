package com.employee.employeemicroservice.service;

import com.employee.employeemicroservice.entity.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081",value = "DEPARTMENT-SERICE")
@FeignClient(name = "DEPARTMENT-MICROSERVICE")
public interface APIClient {
    @GetMapping("/api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);
}
