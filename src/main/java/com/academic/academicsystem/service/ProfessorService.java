package com.academic.academicsystem.service;

import com.academic.academicsystem.model.Professor;
import com.academic.academicsystem.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    // Crear
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    // Obtener todos
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    // Obtener por ID
    public Optional<Professor> getProfessorById(Integer id) {
        return professorRepository.findById(id);
    }

    // Actualizar
    public Optional<Professor> updateProfessor(Integer id, Professor updatedProfessor) {
        return professorRepository.findById(id).map(professor -> {
            professor.setFullname(updatedProfessor.getFullname());
            professor.setEmail(updatedProfessor.getEmail());
            return professorRepository.save(professor);
        });
    }

    // Eliminar
    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }
}



