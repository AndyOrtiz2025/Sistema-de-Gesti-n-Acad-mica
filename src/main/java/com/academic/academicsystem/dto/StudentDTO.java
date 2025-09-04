package com.academic.academicsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private Integer age; // calculada a partir de birthdate
}

