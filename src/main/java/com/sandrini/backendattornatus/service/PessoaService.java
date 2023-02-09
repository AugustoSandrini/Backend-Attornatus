package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private final PessoasRepository pessoasRespository;

    public PessoaService(PessoasRepository pessoasRespository) {
        this.pessoasRespository = pessoasRespository;
    }

    public void listAllPessoas() {
        pessoasRespository.findAll();
    }

    public void createPessoa(Pessoas pessoa) {
        pessoasRespository.save(pessoa);
    }

    public void listPessoaById(Long id) {
        pessoasRespository.findById(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa));
        ResponseEntity.notFound().build();
    }

    public void updatePessoa(Pessoas newPessoa, Long id) {
        pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    updateEndereco(newPessoa, pessoa);
                    return pessoasRespository.save(pessoa);
                })
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    private static void updateEndereco(Pessoas newPessoa, Pessoas pessoa) {
        pessoa.getEndereco().setLogradouro(newPessoa.getEndereco().getLogradouro());
        pessoa.getEndereco().setCep(newPessoa.getEndereco().getCep());
        pessoa.getEndereco().setNumero(newPessoa.getEndereco().getNumero());
        pessoa.getEndereco().setCidade(newPessoa.getEndereco().getCidade());
    }

    public void deletePessoa(Long id) {
        pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoasRespository.delete(pessoa);
                    return ResponseEntity.ok().build();
                });
        ResponseEntity.notFound().build();
    }
}



