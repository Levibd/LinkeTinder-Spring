package com.dantaszg.ms_competencias.repository;

import com.dantaszg.ms_competencias.model.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia,Long> {

    List<Competencia> findByCandidatoId(Long candidatoId);
}
