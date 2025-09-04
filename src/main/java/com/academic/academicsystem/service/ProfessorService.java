package com.academic.academicsystem.service;

import com.academic.academicsystem.dto.ProfessorDTO;
import com.academic.academicsystem.model.Professor;
import com.academic.academicsystem.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    // ------- CRUD existente (igual) -------
    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Integer id) {
        return professorRepository.findById(id);
    }

    public Optional<Professor> updateProfessor(Integer id, Professor updatedProfessor) {
        return professorRepository.findById(id).map(professor -> {
            professor.setFullname(updatedProfessor.getFullname());
            professor.setEmail(updatedProfessor.getEmail());
            return professorRepository.save(professor);
        });
    }

    public void deleteProfessor(Integer id) {
        professorRepository.deleteById(id);
    }

    // ------- NUEVO: GET con DTOs + filtros -------
    public List<ProfessorDTO> getAllProfessorsDTO(String name) {
        List<Professor> list = (name != null && !name.isBlank())
                ? professorRepository.findByFullnameContainingIgnoreCase(name)
                : professorRepository.findAll();

        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<ProfessorDTO> getProfessorDTOById(Integer id) {
        return professorRepository.findById(id).map(this::toDTO);
    }

    private ProfessorDTO toDTO(Professor p) {
        return new ProfessorDTO(
                p.getProfessorId(),
                p.getFullname(),
                p.getEmail()
        );
    }
}




