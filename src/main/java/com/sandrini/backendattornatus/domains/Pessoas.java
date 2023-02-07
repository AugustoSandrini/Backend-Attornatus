package com.sandrini.backendattornatus.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Pessoas {

    private String nome;

    private LocalDate dataNascimento;

    private Endereco endereco;

}
