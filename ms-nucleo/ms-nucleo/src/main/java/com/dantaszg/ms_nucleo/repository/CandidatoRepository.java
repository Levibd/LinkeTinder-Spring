package com.dantaszg.ms_nucleo.repository;

import com.dantaszg.ms_nucleo.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
}
