package com.sandrini.backendattornatus.repository;

import com.sandrini.backendattornatus.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoasRespository extends JpaRepository<Pessoas, Long> {

}
