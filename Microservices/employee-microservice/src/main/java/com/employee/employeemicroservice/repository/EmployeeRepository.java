package com.employee.employeemicroservice.repository;

import com.employee.employeemicroservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
