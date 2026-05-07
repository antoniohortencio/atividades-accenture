package com.accenture.aluno.service;

import com.accenture.aluno.model.Aluno;
import com.accenture.aluno.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor  // Lombok: gera construtor com campo 'final' => injeção automática
public class AlunoService {

    private final AlunoRepository repository;

    // CREATE
    public Aluno salvar(Aluno aluno) {
        aluno.setDataAtualizacao(LocalDateTime.now());
        return repository.save(aluno);
    }

    // READ - todos
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // READ - por ID
    public Aluno buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com id: " + id));
    }

    // UPDATE
    public Aluno atualizar(Integer id, Aluno alunoAtualizado) {
        Aluno existente = buscarPorId(id);
        existente.setNome(alunoAtualizado.getNome());
        existente.setCpf(alunoAtualizado.getCpf());
        existente.setEmail(alunoAtualizado.getEmail());
        existente.setTelefone(alunoAtualizado.getTelefone());
        existente.setDataAtualizacao(LocalDateTime.now());
        return repository.save(existente);
    }

    // DELETE
    public void deletar(Integer id) {
        buscarPorId(id); // garante que existe antes de deletar
        repository.deleteById(id);
    }
}
