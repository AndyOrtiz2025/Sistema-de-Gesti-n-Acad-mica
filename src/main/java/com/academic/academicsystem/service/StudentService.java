package com.academic.academicsystem.service;

import com.academic.academicsystem.model.Student;
import com.academic.academicsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Crear
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Obtener todos
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Obtener por ID
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    // Actualizar
    public Optional<Student> updateStudent(Integer id, Student updated) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstname(updated.getFirstname());
            student.setLastname(updated.getLastname());
            student.setBirthdate(updated.getBirthdate());
            return studentRepository.save(student);
        });
    }

    // Eliminar
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}

