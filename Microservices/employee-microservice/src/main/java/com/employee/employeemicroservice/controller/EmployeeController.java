package com.employee.employeemicroservice.controller;

import com.employee.employeemicroservice.entity.APIResponseDto;
import com.employee.employeemicroservice.entity.Employee;
import com.employee.employeemicroservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController",
        description = "EmployeeController exposes API for employee service"
)
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Save Employee REST API",
            description = "Save Employee REST API is used to save Employee object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get Employee object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @GetMapping("{email}")
    public  ResponseEntity<APIResponseDto> getEmployee(@PathVariable String email){
        APIResponseDto employee = employeeService.getByEmail(email);
        return  new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
