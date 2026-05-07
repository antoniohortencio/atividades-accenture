package com.accenture.aluno.repository;

import com.accenture.aluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    // JpaRepository já fornece: findAll, findById, save, deleteById, etc.
}
