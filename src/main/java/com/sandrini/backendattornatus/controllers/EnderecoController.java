package com.sandrini.backendattornatus.controllers;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    public ResponseEntity<List<Endereco>> listAllEnderecos() {
        try {
            enderecoService.listAllEnderecos();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Endereco> createEndereco(@RequestBody Endereco endereco) {
        try {
            enderecoService.createEndereco(endereco);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        enderecoService.updateEndereco(endereco, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEndereco(@PathVariable("id") Long id) {
        enderecoService.deleteEndereco(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
