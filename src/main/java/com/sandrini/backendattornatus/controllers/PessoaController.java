package com.sandrini.backendattornatus.controllers;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoas> listaPessoas() {
        return pessoaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pessoas> listaPessoaId(@PathVariable("id") Long id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoas createPessoa(@RequestBody Pessoas pessoa) {
        return pessoaService.createPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoas updatePessoa(@RequestBody Pessoas pessoa) {
        return pessoaService.updatePessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable("id") Long id) {
        pessoaService.deletePessoa(id);
    }
}
