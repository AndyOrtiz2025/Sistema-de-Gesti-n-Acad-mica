package com.academic.academicsystem.repository;

import com.academic.academicsystem.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
  List<Professor> findByFullnameContainingIgnoreCase(String fullname);
}
