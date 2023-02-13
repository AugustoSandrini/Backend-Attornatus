package com.sandrini.backendattornatus.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public Pessoas(){
        enderecos = new ArrayList<>();
    }

}
