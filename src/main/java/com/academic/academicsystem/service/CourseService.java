package com.academic.academicsystem.service;

import com.academic.academicsystem.model.Course;
import com.academic.academicsystem.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Crear
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Obtener todos
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Obtener por ID
    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    // Actualizar
    public Optional<Course> updateCourse(Integer id, Course updated) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updated.getName());
            course.setCredits(updated.getCredits());
            course.setSemester(updated.getSemester());
            course.setCycle(updated.getCycle());
            return courseRepository.save(course);
        });
    }

    // Eliminar
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}

