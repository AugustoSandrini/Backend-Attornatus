package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Pessoas> findPessoaById(Long id) {
        return pessoasRespository.findById(id);
    }

    public Pessoas updatePessoa(Pessoas newPessoa, Long id) {
        pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    updateEndereco(newPessoa, pessoa);
                    return pessoasRespository.save(pessoa);
                });
        return newPessoa;
    }

    private static void updateEndereco(Pessoas newPessoa, Pessoas pessoa) {
        pessoa.getEndereco().setLogradouro(newPessoa.getEndereco().getLogradouro());
        pessoa.getEndereco().setCep(newPessoa.getEndereco().getCep());
        pessoa.getEndereco().setNumero(newPessoa.getEndereco().getNumero());
        pessoa.getEndereco().setCidade(newPessoa.getEndereco().getCidade());
    }

    public void deletePessoa(Long id) {
        pessoasRespository.deleteById(id);
    }
}



