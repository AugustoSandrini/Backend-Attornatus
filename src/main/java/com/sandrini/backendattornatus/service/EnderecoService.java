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

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizaEndereco(Endereco newEndereco, Long id) {
        enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setLogradouro(newEndereco.getLogradouro());
                    endereco.setCep(newEndereco.getCep());
                    endereco.setNumero(newEndereco.getNumero());
                    endereco.setCidade(newEndereco.getCidade());
                    return enderecoRepository.save(endereco);
                });
        return newEndereco;
    }

    public void deletaEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
