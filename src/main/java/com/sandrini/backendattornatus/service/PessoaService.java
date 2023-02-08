package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private final PessoasRespository pessoasRespository;

    public PessoaService(PessoasRespository pessoasRespository) {
        this.pessoasRespository = pessoasRespository;
    }

    public List<Pessoas> findAll() {
        return pessoasRespository.findAll();
    }

    public Optional<Pessoas> findById(Long id) {
        return pessoasRespository.findById(id);
    }

    public Pessoas createPessoa(Pessoas pessoa) {
        return pessoasRespository.save(pessoa);
    }

    public Pessoas updatePessoa(Pessoas newPessoa) {
        return pessoasRespository.findById(newPessoa.getId())
                .map(pessoas -> {
                    pessoas.setNome(newPessoa.getNome());
                    pessoas.setDataNascimento(newPessoa.getDataNascimento());
                    pessoas.setEndereco(newPessoa.getEndereco());
                    return pessoasRespository.save(pessoas);
                })
                .orElseGet(() -> {
                    newPessoa.setId(newPessoa.getId());
                    return pessoasRespository.save(newPessoa);
                });
    }

    public void deletePessoa(Long id) {
        pessoasRespository.deleteById(id);
    }


}
