package com.academic.academicsystem.repository;

import com.academic.academicsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CourseRepository extends JpaRepository<Course, Integer> {
// Filtros de ejemplo
    List<Course> findBySemesterIgnoreCase(String semester);
    List<Course> findByProfessor_ProfessorId(Integer professorId);
}


