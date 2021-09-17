package com.impacta.microservices.contacorrente.service;

import com.impacta.microservices.contacorrente.client.CreditoClient;
import com.impacta.microservices.contacorrente.client.response.SaldoCredito;
import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.repository.ContaCorrenteRepository;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteService {

    private ContaCorrenteRepository repository;
    private CreditoClient creditoClient;
   // private DebitoClient debitoClient;

    /*
    public ContaCorrenteService(ContaCorrenteRepository repository,
                               CreditoClient creditoClient,
                               DebitoClient debitoClient) {
        this.repository = repository;
        this.creditoClient = creditoClient;
        this.debitoClient = debitoClient;
    }

     */



    public ContaCorrenteService(ContaCorrenteRepository repository,
                                CreditoClient creditoClient) {
        this.repository = repository;
        this.creditoClient = creditoClient;
    }


    public ContaCorrente criarContaCorrente(ContaCorrente contaCorrente) {
        return repository.save(contaCorrente);
    }

    public ContaCorrente buscarContaConrrente(Integer contaId) {

        return repository.findByContaId(contaId);
    }

    public Double consultaSaldoContaCorrente(Integer contaId) {

        SaldoCredito saldo = creditoClient.getSaldoCreditoConta(contaId);
        var saldoCredito = saldo.getValorCredito();

        return saldoCredito;
    }


}
