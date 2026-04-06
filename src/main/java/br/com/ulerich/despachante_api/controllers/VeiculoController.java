package br.com.ulerich.despachante_api.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ulerich.despachante_api.models.Veiculo;
import br.com.ulerich.despachante_api.repositories.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    @PostMapping
    public Veiculo salvar(@Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}