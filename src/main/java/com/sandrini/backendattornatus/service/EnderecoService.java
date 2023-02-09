package com.sandrini.backendattornatus.service;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void listAllEnderecos() {
        enderecoRepository.findAll();
    }

    public void createEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void updateEndereco(Endereco newEndereco, Long id) {
        enderecoRepository.findById(id)
                .map(endereco -> {
                    endereco.setLogradouro(newEndereco.getLogradouro());
                    endereco.setCep(newEndereco.getCep());
                    endereco.setNumero(newEndereco.getNumero());
                    endereco.setCidade(newEndereco.getCidade());
                    return enderecoRepository.save(endereco);
                });
    }

    public void deleteEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}
