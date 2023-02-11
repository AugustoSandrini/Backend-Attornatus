package com.sandrini.backendattornatus.service;

import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.EnderecoRepository;
import com.sandrini.backendattornatus.repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoasRepository pessoasRespository;

    public PessoaService(PessoasRepository pessoasRespository, EnderecoRepository enderecoRepository) {
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
                    pessoa.setEndereco(newPessoa.getEndereco());
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
    }
     */

    public void deletaPessoa(Long id) {
        pessoasRespository.deleteById(id);
    }

    public Optional<Endereco> listarEnderecosPorPessoa(Long id) {
        return pessoasRespository.findById(id)
                .map(Pessoas::getEndereco);
    }
}



