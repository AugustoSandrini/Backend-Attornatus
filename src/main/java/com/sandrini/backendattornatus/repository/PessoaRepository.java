package com.sandrini.backendattornatus.repository;

import com.sandrini.backendattornatus.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoas, Long> {
}
