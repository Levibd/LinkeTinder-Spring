package com.dantaszg.ms_nucleo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_candidato_vaga")
public class CandidatoVaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private boolean gosteiCandidato;
    private boolean gosteiEmpresa;

    public boolean isMatch() {
        return gosteiCandidato && gosteiEmpresa;
    }
}
