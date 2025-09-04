package com.academic.academicsystem.repository;

import com.academic.academicsystem.dto.CourseAvgGradeDTO;
import com.academic.academicsystem.dto.StudentsByCycleDTO;
import com.academic.academicsystem.dto.TopCourseDTO;
import com.academic.academicsystem.model.Inscription;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    // Reporte 2: promedio de notas por curso
    @Query("""
        SELECT new com.academic.academicsystem.dto.CourseAvgGradeDTO(
            c.courseId, c.name, AVG(i.finalGrade)
        )
        FROM Inscription i
        JOIN i.course c
        WHERE i.finalGrade IS NOT NULL
        GROUP BY c.courseId, c.name
        ORDER BY c.name
    """)
    List<CourseAvgGradeDTO> avgGradePerCourse();

    // Reporte 3: cantidad de estudiantes por ciclo (DISTINCT)
    @Query("""
        SELECT new com.academic.academicsystem.dto.StudentsByCycleDTO(
            c.cycle, COUNT(DISTINCT i.student.studentId)
        )
        FROM Inscription i
        JOIN i.course c
        GROUP BY c.cycle
        ORDER BY c.cycle
    """)
    List<StudentsByCycleDTO> countStudentsByCycle();

    // Reporte 4: top cursos por promedio (desc)
    @Query("""
        SELECT new com.academic.academicsystem.dto.TopCourseDTO(
            c.courseId, c.name, AVG(i.finalGrade)
        )
        FROM Inscription i
        JOIN i.course c
        WHERE i.finalGrade IS NOT NULL
        GROUP BY c.courseId, c.name
        ORDER BY AVG(i.finalGrade) DESC
    """)
    List<TopCourseDTO> topCoursesByAvgGrade(Pageable pageable);
}

