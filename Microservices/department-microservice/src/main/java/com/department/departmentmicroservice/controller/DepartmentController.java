package com.department.departmentmicroservice.controller;

import com.department.departmentmicroservice.dto.DepartmentDto;
import com.department.departmentmicroservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "DepartmentController exposes API for department service"
)
@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Save Department REST API",
            description = "Save department REST API is used to save department object in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP status 201 created"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get Department REST API",
            description = "Get department REST API is used to get department object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP status 200 success"
    )
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode){
        DepartmentDto getDepartmentDto = departmentService.getByDepartmentCode(departmentCode);
        return new ResponseEntity<>(getDepartmentDto, HttpStatus.OK);
    }
}
