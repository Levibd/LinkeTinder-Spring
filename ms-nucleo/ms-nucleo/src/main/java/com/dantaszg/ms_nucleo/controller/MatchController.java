package com.dantaszg.ms_nucleo.controller;

import com.dantaszg.ms_nucleo.model.Candidato;
import com.dantaszg.ms_nucleo.model.CandidatoVaga;
import com.dantaszg.ms_nucleo.model.Vaga;
import com.dantaszg.ms_nucleo.repository.CandidatoRepository;
import com.dantaszg.ms_nucleo.repository.CandidatoVagaRepository;
import com.dantaszg.ms_nucleo.repository.VagaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interacoes")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MatchController {

    private final CandidatoVagaRepository repository;
    private final CandidatoRepository candidatoRepository;
    private final VagaRepository vagaRepository;

    @PostMapping("/curtir")
    public ResponseEntity<String> registrarCurtida(@RequestBody DadosCurtida dto) {


        Candidato candidato = candidatoRepository.findById(dto.getCandidatoId())
                .orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
        Vaga vaga = vagaRepository.findById(dto.getVagaId())
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));


        CandidatoVaga interacao = repository.findByCandidatoAndVaga(candidato, vaga)
                .orElse(new CandidatoVaga());


        interacao.setCandidato(candidato);
        interacao.setVaga(vaga);


        if ("CANDIDATO".equalsIgnoreCase(dto.getTipoUsuario())) {
            interacao.setGosteiCandidato(true);
        } else if ("EMPRESA".equalsIgnoreCase(dto.getTipoUsuario())) {
            interacao.setGosteiEmpresa(true);
        }

        repository.save(interacao);


        if (interacao.isMatch()) {
            return ResponseEntity.ok("IT'S A MATCH! 🔥 O candidato e a empresa se curtiram.");
        }

        return ResponseEntity.ok("Curtida registrada. Aguardando a outra parte...");
    }
}


@Data
class DadosCurtida {
    private Long candidatoId;
    private Long vagaId;
    private String tipoUsuario;
}