package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoasRepository pessoasRespository;

    public PessoaService(PessoasRepository pessoasRespository) {
        this.pessoasRespository = pessoasRespository;
    }

    public List<Pessoas> listAllPessoas() {
        return pessoasRespository.findAll();
    }

    public Pessoas createPessoa(Pessoas pessoa) {
        return pessoasRespository.save(pessoa);
    }

    public ResponseEntity<Pessoas> listPessoaById(Long id) {
        return pessoasRespository.findById(id)
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Pessoas> updatePessoa(Pessoas newPessoa, Long id) {
        return pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    updateEndereco(newPessoa, pessoa);
                    return pessoasRespository.save(pessoa);
                })
                .map(pessoa -> ResponseEntity.ok().body(pessoa))
                .orElse(ResponseEntity.notFound().build());
    }

    private static void updateEndereco(Pessoas newPessoa, Pessoas pessoa) {
        pessoa.getEndereco().setLogradouro(newPessoa.getEndereco().getLogradouro());
        pessoa.getEndereco().setCep(newPessoa.getEndereco().getCep());
        pessoa.getEndereco().setNumero(newPessoa.getEndereco().getNumero());
        pessoa.getEndereco().setCidade(newPessoa.getEndereco().getCidade());
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



