package com.employee.employeemicroservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Employee Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(
            description = "Employee first name"
    )
    private String firstName;
    @Schema(
            description = "Employee last name"
    )
    private String lastName;

    @Schema(
            description = "Employee email"
    )
    @Column(nullable = false,unique = true)
    private String email;

    @Schema(
            description = "Employee department code"
    )
    @Column(nullable = false)
    private String departmentCode;

    @Schema(
            description = "Employee organization code"
    )
    @Column(nullable = false)
    private String organizationCode;

}
