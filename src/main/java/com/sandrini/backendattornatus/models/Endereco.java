package com.sandrini.backendattornatus.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;


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

    private boolean enderecoPrincial;

}
