package com.sandrini.backendattornatus.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;

    private String cep;

    private int numero;

    private String cidade;

    private Long pessoa_id;

    private boolean enderecoPrincial;
}
