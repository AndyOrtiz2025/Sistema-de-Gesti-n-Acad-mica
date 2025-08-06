package com.academic.academicsystem.repository;

import com.academic.academicsystem.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
