package com.dantaszg.ms_nucleo.repository;

import com.dantaszg.ms_nucleo.model.Candidato;
import com.dantaszg.ms_nucleo.model.CandidatoVaga;
import com.dantaszg.ms_nucleo.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatoVagaRepository extends JpaRepository<CandidatoVaga, Long> {
    Optional<CandidatoVaga> findByCandidatoAndVaga(Candidato candidato, Vaga vaga);
}
