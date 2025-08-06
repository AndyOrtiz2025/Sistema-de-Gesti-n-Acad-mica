package com.academic.academicsystem.repository;

import com.academic.academicsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}


