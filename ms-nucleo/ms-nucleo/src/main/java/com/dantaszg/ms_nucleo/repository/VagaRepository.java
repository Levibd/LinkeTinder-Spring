package com.dantaszg.ms_nucleo.repository;

import com.dantaszg.ms_nucleo.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
