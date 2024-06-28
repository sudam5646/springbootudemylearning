package com.docker.springboot_docker_demo.controller;

import com.docker.springboot_docker_demo.entity.Department;
import com.docker.springboot_docker_demo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department departmentDto){

        Department savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);

    }


    @GetMapping("{departmentCode}")
    public ResponseEntity<Department> getDepartment(@PathVariable String departmentCode){
        Department getDepartmentDto = departmentService.getByDepartmentCode(departmentCode);
        return new ResponseEntity<>(getDepartmentDto, HttpStatus.OK);
    }
}
