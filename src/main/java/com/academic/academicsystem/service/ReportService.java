package com.academic.academicsystem.service;

import com.academic.academicsystem.dto.*;
import com.academic.academicsystem.repository.CourseRepository;
import com.academic.academicsystem.repository.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final CourseRepository courseRepository;
    private final InscriptionRepository inscriptionRepository;

    public List<ProfessorCourseCountDTO> coursesPerProfessor() {
        return courseRepository.countCoursesByProfessor();
    }

    public List<CourseAvgGradeDTO> avgGradePerCourse() {
        return inscriptionRepository.avgGradePerCourse();
    }

    public List<StudentsByCycleDTO> studentsByCycle() {
        return inscriptionRepository.countStudentsByCycle();
    }

    public List<TopCourseDTO> topCoursesByAverage(int limit) {
        return inscriptionRepository.topCoursesByAvgGrade(PageRequest.of(0, limit));
    }
}
