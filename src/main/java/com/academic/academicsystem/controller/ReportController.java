package com.academic.academicsystem.controller;

import com.academic.academicsystem.dto.*;
import com.academic.academicsystem.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/professors/course-count")
    public List<ProfessorCourseCountDTO> coursesPerProfessor() {
        return reportService.coursesPerProfessor();
    }

    @GetMapping("/courses/avg-grade")
    public List<CourseAvgGradeDTO> avgGradePerCourse() {
        return reportService.avgGradePerCourse();
    }

    @GetMapping("/enrollments/by-cycle")
    public List<StudentsByCycleDTO> enrollmentsByCycle() {
        return reportService.studentsByCycle();
    }

    @GetMapping("/courses/top")
    public List<TopCourseDTO> topCourses(@RequestParam(defaultValue = "3") int limit) {
        return reportService.topCoursesByAverage(limit);
    }
}

