package com.academic.academicsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Integer id;
    private String name;
    private int credits;
    private String semester;
    private String cycle;
    private Integer professorId;   // relación mínima segura
    private String professorName;  // para mostrar en listados
}

