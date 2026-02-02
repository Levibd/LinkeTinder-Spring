package com.dantaszg.ms_nucleo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_candidatos")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private String pais;
    private String descricao;
    private String senha;
}
