package com.academic.academicsystem.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class CourseAvgGradeDTO {
    private Integer courseId;
    private String courseName;
    private Double averageGrade;
}
