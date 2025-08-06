package com.academic.academicsystem.controller;

import com.academic.academicsystem.model.Course;
import com.academic.academicsystem.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // POST - Crear
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    // GET - Obtener todos
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // GET - Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Integer id, @RequestBody Course course) {
        return courseService.updateCourse(id, course)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}

