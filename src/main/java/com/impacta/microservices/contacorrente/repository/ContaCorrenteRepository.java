package com.impacta.microservices.contacorrente.repository;

import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
    ContaCorrente findByContaId(Integer contaId);
}
