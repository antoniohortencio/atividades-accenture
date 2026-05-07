package com.accenture.pessoa.service;

import com.accenture.pessoa.entity.Pessoa;
import com.accenture.pessoa.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com id: " + id));
    }

    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        Pessoa existente = buscarPorId(id);
        existente.setNome(pessoaAtualizada.getNome());
        existente.setEmail(pessoaAtualizada.getEmail());
        existente.setTelefone(pessoaAtualizada.getTelefone());
        existente.setCpf(pessoaAtualizada.getCpf());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
