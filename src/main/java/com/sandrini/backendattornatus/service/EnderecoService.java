package com.sandrini.backendattornatus.service;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco criarEndereco(Long id, Pessoas pessoa) {
        pessoa.setId(id);
        return enderecoRepository.save(pessoa.getEndereco());
    }

}
