package com.sandrini.backendattornatus.controllers;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import com.sandrini.backendattornatus.service.EnderecoService;
import com.sandrini.backendattornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{id}")
    public ResponseEntity<Object> criarEndereco(@RequestBody Endereco endereco) {
        try {
            return ResponseEntity.ok().body(enderecoService.criarEndereco(endereco));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizaEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        try {
            return ResponseEntity.ok().body(enderecoService.atualizaEndereco(endereco, id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaEndereco(@PathVariable("id") Long id) {
        try {
            enderecoService.deletaEndereco(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
