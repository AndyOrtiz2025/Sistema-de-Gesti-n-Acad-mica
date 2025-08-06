package com.academic.academicsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  studentId;

    private String firstname;

    private String lastname;

    private java.time.LocalDate birthdate;
}

