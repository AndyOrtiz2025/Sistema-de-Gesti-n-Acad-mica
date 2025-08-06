package com.academic.academicsystem.controller;

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

    // POST - Crear
    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    // GET - Obtener todos
    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    // GET - Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Integer id) {
        return professorService.getProfessorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Integer id, @RequestBody Professor professor) {
        return professorService.updateProfessor(id, professor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}


