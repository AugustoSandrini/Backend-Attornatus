package com.sandrini.backendattornatus.controllers;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoas> listarPessoas() {
        return pessoaService.findAllPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoas> listaPessoaById(@PathVariable("id") Long id) {
        return pessoaService.findPessoaById(id);
    }

    @PostMapping
    public Pessoas createPessoa(@RequestBody Pessoas pessoa) {
        return pessoaService.createPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> updatePessoa(@PathVariable("id") Long id, @RequestBody Pessoas pessoa) {
        return pessoaService.updatePessoa(pessoa, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable("id") Long id) {
       return pessoaService.deletePessoa(id);
    }
}
