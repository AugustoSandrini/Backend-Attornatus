package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private final PessoasRespository pessoasRespository;

    public PessoaService(PessoasRespository pessoasRespository) {
        this.pessoasRespository = pessoasRespository;
    }

    public List<Pessoas> findAllPessoas() {
        return pessoasRespository.findAll();
    }

    public Pessoas createPessoa(Pessoas pessoa) {
        return pessoasRespository.save(pessoa);
    }

    public ResponseEntity<Pessoas> findPessoaById(Long id) {
        return pessoasRespository.findById(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Pessoas> updatePessoa(Pessoas newPessoa, Long id) {
        return pessoasRespository.findById(id)
                .map(pessoas -> {
                    pessoas.setNome(newPessoa.getNome());
                    pessoas.setDataNascimento(newPessoa.getDataNascimento());
                    pessoas.setEndereco(newPessoa.getEndereco());
                    return pessoasRespository.save(pessoas);
                })
                .map(pessoas -> ResponseEntity.ok().body(pessoas))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deletePessoa(Long id) {
        return pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoasRespository.delete(pessoa);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}



