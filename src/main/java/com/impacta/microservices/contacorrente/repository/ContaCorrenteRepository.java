package com.impacta.microservices.contacorrente.repository;

import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

    Optional<ContaCorrente> findByContaId(Integer contaId);
}
