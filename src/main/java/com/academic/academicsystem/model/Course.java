package com.academic.academicsystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    private String name;

    private int credits;

    private String semester;

    private String cycle;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;
}
 


