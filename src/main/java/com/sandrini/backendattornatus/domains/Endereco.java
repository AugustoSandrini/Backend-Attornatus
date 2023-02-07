package com.sandrini.backendattornatus.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Endereco {

    private String logradouro;

    private String cep;

    private int numero;

    private String cidade;

}
