package com.accenture.aluno.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data                   // @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@NoArgsConstructor      // Construtor vazio (obrigatório para JPA)
@AllArgsConstructor     // Construtor com todos os campos
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String cpf;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(length = 255)
    private String telefone;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String nome;
}
