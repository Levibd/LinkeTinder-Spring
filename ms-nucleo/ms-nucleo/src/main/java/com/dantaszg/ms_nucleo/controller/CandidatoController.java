package com.dantaszg.ms_nucleo.controller;

import com.dantaszg.ms_nucleo.model.Candidato;
import com.dantaszg.ms_nucleo.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
@CrossOrigin("*")
@RequiredArgsConstructor
public class CandidatoController {

    private final CandidatoRepository repository;

    @GetMapping
    public List<Candidato> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Candidato cadastrar(@RequestBody Candidato candidato) {
        return repository.save(candidato);
    }

}
