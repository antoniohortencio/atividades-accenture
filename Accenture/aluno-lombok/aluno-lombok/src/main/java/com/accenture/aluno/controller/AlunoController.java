package com.accenture.aluno.controller;

import com.accenture.aluno.model.Aluno;
import com.accenture.aluno.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor  // Lombok: injeta AlunoService via construtor
public class AlunoController {

    private final AlunoService service;

    // POST /aluno — Criar novo aluno
    @PostMapping
    public ResponseEntity<Aluno> saveAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(aluno));
    }

    // GET /aluno — Listar todos
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAluno() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET /aluno/{id} — Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // PUT /aluno/{id} — Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
        return ResponseEntity.ok(service.atualizar(id, aluno));
    }

    // DELETE /aluno/{id} — Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
