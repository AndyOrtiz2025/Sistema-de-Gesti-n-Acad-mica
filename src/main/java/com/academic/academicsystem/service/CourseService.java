package com.academic.academicsystem.service;

import com.academic.academicsystem.dto.CourseDTO;
import com.academic.academicsystem.model.Course;
import com.academic.academicsystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // ------- CRUD existente (dejas igual) -------
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> updateCourse(Integer id, Course updated) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updated.getName());
            course.setCredits(updated.getCredits());
            course.setSemester(updated.getSemester());
            course.setCycle(updated.getCycle());
            course.setProfessor(updated.getProfessor());
            return courseRepository.save(course);
        });
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    // ------- NUEVO: GET con DTOs + filtros -------
    public List<CourseDTO> getAllCoursesDTO(String semester, Integer professorId) {
        List<Course> courses;

        if (semester != null && !semester.isBlank()) {
            courses = courseRepository.findBySemesterIgnoreCase(semester);
        } else if (professorId != null) {
            courses = courseRepository.findByProfessor_ProfessorId(professorId);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<CourseDTO> getCourseDTOById(Integer id) {
        return courseRepository.findById(id).map(this::toDTO);
    }

    private CourseDTO toDTO(Course course) {
        Integer profId = course.getProfessor() != null ? course.getProfessor().getProfessorId() : null;
        String profName = course.getProfessor() != null ? course.getProfessor().getFullname() : null;

        return new CourseDTO(
                course.getCourseId(),
                course.getName(),
                course.getCredits(),
                course.getSemester(),
                course.getCycle(),
                profId,
                profName
        );
    }
}


