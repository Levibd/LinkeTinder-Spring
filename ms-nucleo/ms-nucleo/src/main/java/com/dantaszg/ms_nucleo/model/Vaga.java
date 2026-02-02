package com.dantaszg.ms_nucleo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_vagas")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String local;

    @ElementCollection
    private List<String> competenciasRequeridas;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
