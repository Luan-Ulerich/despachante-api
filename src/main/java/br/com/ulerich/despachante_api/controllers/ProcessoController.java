package br.com.ulerich.despachante_api.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ulerich.despachante_api.models.Processo;
import br.com.ulerich.despachante_api.repositories.ProcessoRepository;

@RestController
@RequestMapping("/processos")
public class ProcessoController {

    @Autowired
    private ProcessoRepository processoRepository;

    @GetMapping
    public List<Processo> listarTodos() {
        return processoRepository.findAll();
    }

    @PostMapping
    public Processo salvar(@Valid @RequestBody Processo processo) {
        return processoRepository.save(processo);
    }
}