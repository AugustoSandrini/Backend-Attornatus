package com.sandrini.backendattornatus.controllers;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        try {
            return ResponseEntity.ok().body(enderecoService.listarEnderecos());
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/")
    public ResponseEntity<Long> criarEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        try {
            return ResponseEntity.ok().body(enderecoService.criarEnderecoParaPessoa(id, endereco));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
