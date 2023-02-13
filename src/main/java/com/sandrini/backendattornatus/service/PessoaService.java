package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoasRespository) {
        this.pessoaRepository = pessoasRespository;
    }

    public List<Pessoas> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoas criarPessoa(Pessoas pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoas> acharPessoaPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoas atualizaPessoa(Pessoas newPessoa, Long id) {
        pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    pessoa.getEnderecos().clear();
                    pessoa.getEnderecos().addAll(newPessoa.getEnderecos());
                    return pessoaRepository.save(pessoa);
                });
        return newPessoa;
    }

    public void deletaPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Optional<List<Endereco>> listarEnderecosPessoa(Long id) {
        return pessoaRepository.findById(id)
                .map(Pessoas::getEnderecos);
    }

    public Optional<Endereco> listarEnderecoPrincipal(Long id) {
        Pessoas pessoa = pessoaRepository.findById(id).orElse(null);
        assert pessoa != null;
        Stream<Endereco> endereco = pessoa.getEnderecos().stream().filter(Endereco::isEnderecoPrincial);
        return endereco.findAny();
    }

    public Endereco criarEnderecoParaPessoa(Long id, Endereco newEndereco) {
        pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.getEnderecos().add(newEndereco);
                    return pessoaRepository.save(pessoa);
                });
        return newEndereco;
    }

}




