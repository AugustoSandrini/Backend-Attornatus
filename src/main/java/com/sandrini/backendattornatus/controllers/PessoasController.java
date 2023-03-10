package com.sandrini.backendattornatus.controllers;

import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoas>> listarPessoas() {
        try {
            return ResponseEntity.ok().body(pessoaService.listarPessoas());
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoas>> acharPessoaPorId(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(pessoaService.acharPessoaPorId(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/enderecos")
    public ResponseEntity<Optional<List<Endereco>>> listarEnderecosPessoa(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(pessoaService.listarEnderecosPessoa(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/endereco-principal")
    public ResponseEntity<Optional<Endereco>> listarEnderecoPrincipal(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok().body(pessoaService.listarEnderecoPrincipal(id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("add-endereco/{id}")
    public ResponseEntity<Endereco> criarEndereco(@PathVariable("id") Long id, @RequestBody Endereco newEndereco) {
        try {
            return ResponseEntity.ok().body(pessoaService.criarEnderecoParaPessoa(id ,newEndereco));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Pessoas> criarPessoa(@RequestBody Pessoas pessoa) {
        try {
            return ResponseEntity.ok().body(pessoaService.criarPessoa(pessoa));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> atualizaPessoa(@PathVariable("id") Long id, @RequestBody Pessoas pessoa) {
        try {
            return ResponseEntity.ok().body(pessoaService.atualizaPessoa(pessoa, id));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPessoa(@PathVariable("id") Long id) {
        try {
            pessoaService.deletaPessoa(id);
            return ResponseEntity.noContent().build();
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
