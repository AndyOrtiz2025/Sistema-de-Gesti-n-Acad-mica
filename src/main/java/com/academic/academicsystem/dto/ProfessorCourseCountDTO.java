package com.academic.academicsystem.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProfessorCourseCountDTO {
    private Integer professorId;
    private String professorName;
    private Long totalCourses;
}
