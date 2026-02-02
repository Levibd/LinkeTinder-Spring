package com.dantaszg.ms_competencias.controller;

import com.dantaszg.ms_competencias.model.Competencia;
import com.dantaszg.ms_competencias.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CompetenciaController {


    private CompetenciaRepository repository;

    @GetMapping
    public List<Competencia> listar() {
        return repository.findAll();
    }

    @GetMapping("/candidato/{id}")
    public List<Competencia> listarPorCandidato(@PathVariable Long id) {
        return repository.findByCandidatoId(id);
    }

    @PostMapping
    public Competencia cadastrar(@RequestBody Competencia competencia) {
        return repository.save(competencia);
    }
}