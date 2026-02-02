package com.dantaszg.ms_nucleo.controller;

import com.dantaszg.ms_nucleo.model.Vaga;
import com.dantaszg.ms_nucleo.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VagaController {

    private final VagaRepository repository;

    @GetMapping
    public List<Vaga> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Vaga cadastrar(@RequestBody Vaga vaga) {

        return repository.save(vaga);
    }
}