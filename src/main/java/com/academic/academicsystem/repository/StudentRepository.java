package com.academic.academicsystem.repository;

import com.academic.academicsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
 List<Student> findByLastnameContainingIgnoreCase(String lastname);
}

