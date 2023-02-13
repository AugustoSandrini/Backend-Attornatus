package com.sandrini.backendattornatus.Testes;


import com.sandrini.backendattornatus.models.Endereco;
import com.sandrini.backendattornatus.models.Pessoas;
import com.sandrini.backendattornatus.repository.PessoaRepository;
import com.sandrini.backendattornatus.service.PessoaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTeste {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void listarPessoasTeste() {
        List<Pessoas> expectedPessoas = Arrays.asList(new Pessoas(), new Pessoas());
        when(pessoaRepository.findAll()).thenReturn(expectedPessoas);

        List<Pessoas> resultado = pessoaService.listarPessoas();

        assertThat(resultado, equalTo(expectedPessoas));

        verify(pessoaRepository).findAll();
    }

    @Test
    void criarPessoaTeste() {
        Pessoas pessoa = new Pessoas();
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoas resultado = pessoaService.criarPessoa(pessoa);

        assertThat(resultado, equalTo(pessoa));
        verify(pessoaRepository).save(pessoa);
    }

    @Test
    void acharPessoaPorIdTeste() {
        Long id = 1L;
        Optional<Pessoas> expectedPessoa = Optional.of(new Pessoas());
        when(pessoaRepository.findById(id)).thenReturn(expectedPessoa);

        Optional<Pessoas> resultado = pessoaService.acharPessoaPorId(id);

        assertThat(resultado, equalTo(expectedPessoa));
        verify(pessoaRepository).findById(id);
    }

    @Test
    public void atualizaPessoaTeste() {
        Long id = 1L;
        Pessoas newPessoa = new Pessoas();
        newPessoa.setNome("Augusto");
        newPessoa.setDataNascimento("01/01/2000");

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco());
        enderecos.add(new Endereco());
        newPessoa.setEnderecos(enderecos);

        Pessoas pessoa = new Pessoas();
        pessoa.setNome("Augusto1");
        pessoa.setDataNascimento("2002-06-15");

        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoas resultado = pessoaService.atualizaPessoa(newPessoa, id);
        assertEquals(newPessoa, resultado);
    }

    @Test
    void deletaPessoaTeste() {
        Long id = 1L;

        pessoaService.deletaPessoa(id);

        verify(pessoaRepository).deleteById(id);
    }


}
