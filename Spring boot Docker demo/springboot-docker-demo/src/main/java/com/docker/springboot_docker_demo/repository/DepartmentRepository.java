package com.docker.springboot_docker_demo.repository;

import com.docker.springboot_docker_demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
