package br.com.ulerich.despachante_api.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ulerich.despachante_api.models.Cliente;
import br.com.ulerich.despachante_api.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }


    @PostMapping
    public Cliente salvar(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}