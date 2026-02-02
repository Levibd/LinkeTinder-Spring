package com.dantaszg.ms_nucleo.controller;

import com.dantaszg.ms_nucleo.model.Empresa;
import com.dantaszg.ms_nucleo.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
@CrossOrigin("*")
@RequiredArgsConstructor
public class EmpresaController {

    private final EmpresaRepository repository;

    @GetMapping
    public List<Empresa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Empresa cadastrar(@RequestBody Empresa empresa) {
        return repository.save(empresa);
    }
}