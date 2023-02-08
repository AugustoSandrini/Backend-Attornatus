package com.sandrini.backendattornatus.controllers;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> listAllEnderecos() {
        return enderecoService.listAllEnderecos();
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> listEnderecoById(@PathVariable("id") Long id) {
        return enderecoService.findEnderecoById(id);
    }
     */



    @PostMapping
    public Endereco createEndereco(@RequestBody Endereco endereco) {
        return enderecoService.createEndereco(endereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        return enderecoService.updateEndereco(endereco, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEndereco(@PathVariable("id") Long id) {
        return enderecoService.deleteEndereco(id);
    }


}
