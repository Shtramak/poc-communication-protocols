package com.bobocode.petros.openapiserver.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfBirth;
    private String email;
}
