package com.employee.employeemicroservice.service;

import com.employee.employeemicroservice.entity.APIResponseDto;
import com.employee.employeemicroservice.entity.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    APIResponseDto getByEmail(String email);
}
