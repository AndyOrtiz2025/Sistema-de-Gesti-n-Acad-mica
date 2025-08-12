package com.academic.academicsystem.controller;

import com.academic.academicsystem.dto.ProfessorDTO;
import com.academic.academicsystem.model.Professor;
import com.academic.academicsystem.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // POST - Crear (igual)
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    // GET - Obtener todos → ahora DTO + filtro por nombre
    // Ej: /api/professors?name=perez
    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors(
            @RequestParam(required = false, name = "name") String name
    ) {
        return ResponseEntity.ok(professorService.getAllProfessorsDTO(name));
    }

    // GET - Obtener por ID → ahora DTO
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Integer id) {
        return professorService.getProfessorDTOById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Actualizar (igual)
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Integer id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar (igual)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}



