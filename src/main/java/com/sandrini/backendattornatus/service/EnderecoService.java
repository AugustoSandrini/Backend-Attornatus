package com.sandrini.backendattornatus.service;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final PessoasRepository pessoasRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoasRepository pessoasRepository, PessoasRepository pessoasRepository1) {
        this.enderecoRepository = enderecoRepository;
        this.pessoasRepository = pessoasRepository1;
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Long criarEnderecoParaPessoa(Long id, Endereco endereco) {
        Optional<Pessoas> pessoa = pessoasRepository.findById(id);
        pessoa.get().getEndereco().add(endereco);
        return pessoa.get().getId();
    }

}
