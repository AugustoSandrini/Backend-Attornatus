package com.sandrini.backendattornatus.service;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> listAllEnderecos() {
        return enderecoRepository.findAll();
    }

    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public ResponseEntity<Endereco> listEnderecoById(Long id) {
        return enderecoRepository.findById(id)
                .map(endereco -> ResponseEntity.ok().body(endereco))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Endereco> updateEndereco(Endereco newEndereco, Long id) {
        return enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setLogradouro(newEndereco.getLogradouro());
                    endereco.setCep(newEndereco.getCep());
                    endereco.setNumero(newEndereco.getNumero());
                    endereco.setCidade(newEndereco.getCidade());
                    return enderecoRepository.save(newEndereco);
                })
                .map(endereco -> ResponseEntity.ok().body(endereco))
                .orElse(ResponseEntity.notFound().build());

    }

    public ResponseEntity<Object> deleteEndereco(Long id) {
        return enderecoRepository.findById(id)
                .map(endereco -> {
                    enderecoRepository.delete(endereco);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
