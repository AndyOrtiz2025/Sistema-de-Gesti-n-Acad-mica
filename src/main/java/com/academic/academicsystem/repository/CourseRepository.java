package com.academic.academicsystem.repository;

import com.academic.academicsystem.dto.ProfessorCourseCountDTO;
import com.academic.academicsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Filtros de ejemplo (los que ya tenías)
    List<Course> findBySemesterIgnoreCase(String semester);
    List<Course> findByProfessor_ProfessorId(Integer professorId);

    // REPORTE #1: número total de cursos que imparte cada profesor
    @Query(
        "SELECT new com.academic.academicsystem.dto.ProfessorCourseCountDTO(" +
        "       p.professorId, p.fullname, COUNT(c)) " +
        "FROM Course c " +
        "JOIN c.professor p " +
        "GROUP BY p.professorId, p.fullname " +
        "ORDER BY p.fullname"
    )
    List<ProfessorCourseCountDTO> countCoursesByProfessor();
}



