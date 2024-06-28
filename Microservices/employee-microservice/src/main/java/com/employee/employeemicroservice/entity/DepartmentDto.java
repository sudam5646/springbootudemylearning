package com.employee.employeemicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private  long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
