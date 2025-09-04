package com.academic.academicsystem.service;

import com.academic.academicsystem.dto.StudentDTO;
import com.academic.academicsystem.model.Student;
import com.academic.academicsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // ------- CRUD existente (igual) -------
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> updateStudent(Integer id, Student updated) {
        return studentRepository.findById(id).map(student -> {
            student.setFirstname(updated.getFirstname());
            student.setLastname(updated.getLastname());
            student.setBirthdate(updated.getBirthdate());
            return studentRepository.save(student);
        });
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    // ------- NUEVO: GET con DTOs + filtros -------
    public List<StudentDTO> getAllStudentsDTO(String lastname) {
        List<Student> list = (lastname != null && !lastname.isBlank())
                ? studentRepository.findByLastnameContainingIgnoreCase(lastname)
                : studentRepository.findAll();

        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentDTOById(Integer id) {
        return studentRepository.findById(id).map(this::toDTO);
    }

    private StudentDTO toDTO(Student s) {
        Integer age = null;
        if (s.getBirthdate() != null) {
            age = Period.between(s.getBirthdate(), LocalDate.now()).getYears();
        }
        return new StudentDTO(
                s.getStudentId(),
                s.getFirstname(),
                s.getLastname(),
                age
        );
        // Nota: deliberadamente no exponemos birthdate completa.
    }
}

