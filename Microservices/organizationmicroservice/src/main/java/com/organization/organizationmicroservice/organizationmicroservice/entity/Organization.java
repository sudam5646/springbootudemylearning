package com.organization.organizationmicroservice.organizationmicroservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Organization Model Information"
)
@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
            description = "Organization name"
    )
    @Column(nullable = false)
    private String organizationName;

    @Schema(
            description = "Organization description"
    )
    private  String organizationDescription;

    @Schema(
            description = "Organization code"
    )
    @Column(nullable = false, unique = true)
    private  String organizationCode;
}
