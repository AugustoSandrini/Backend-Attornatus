package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PessoaService {

    private final PessoasRepository pessoasRespository;

    public PessoaService(PessoasRepository pessoasRespository) {
        this.pessoasRespository = pessoasRespository;
    }

    public List<Pessoas> listarPessoas() {
        return pessoasRespository.findAll();
    }

    public Pessoas criarPessoa(Pessoas pessoa) {
        return pessoasRespository.save(pessoa);
    }

    public Optional<Pessoas> acharPessoaPorId(Long id) {
        return pessoasRespository.findById(id);
    }

    public Pessoas atualizaPessoa(Pessoas newPessoa, Long id) {
        pessoasRespository.findById(id)
                .map(pessoa -> {
                    pessoa.setNome(newPessoa.getNome());
                    pessoa.setDataNascimento(newPessoa.getDataNascimento());
                    pessoa.getEndereco().clear();
                    pessoa.getEndereco().addAll(newPessoa.getEndereco());
                    //atualizaEndereco(newPessoa, pessoa);
                    return pessoasRespository.save(pessoa);
                });
        return newPessoa;
    }

    /*

    private static void atualizaEndereco(Pessoas newPessoa, Pessoas pessoa) {
        pessoa.getEndereco().setLogradouro(newPessoa.getEndereco().getLogradouro());
        pessoa.getEndereco().setCep(newPessoa.getEndereco().getCep());
        pessoa.getEndereco().setNumero(newPessoa.getEndereco().getNumero());
        pessoa.getEndereco().setCidade(newPessoa.getEndereco().getCidade());
        pessoa.getEndereco().setEnderecoPrincial(newPessoa.getEndereco().isEnderecoPrincial());
    }
     */


    public void deletaPessoa(Long id) {
        pessoasRespository.deleteById(id);
    }

    public Optional<List<Endereco>> listarEnderecosPessoa(Long id) {
        return pessoasRespository.findById(id)
                .map(Pessoas::getEndereco);
    }

    public Optional<Endereco> listarEnderecoPrincipal(Long id) {
        Pessoas pessoa = pessoasRespository.findById(id).orElse(null);
        assert pessoa != null;
        Stream<Endereco> endereco = pessoa.getEndereco().stream().filter(Endereco::isEnderecoPrincial);
        return endereco.findAny();
    }
}




