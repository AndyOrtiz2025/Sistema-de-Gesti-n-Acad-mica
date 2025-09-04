package com.academic.academicsystem.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class StudentsByCycleDTO {
    private String cycle;
    private Long students;
}
