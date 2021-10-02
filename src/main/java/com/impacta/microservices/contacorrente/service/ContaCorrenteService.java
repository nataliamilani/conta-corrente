package com.impacta.microservices.contacorrente.service;

import com.impacta.microservices.contacorrente.client.CreditoClient;
import com.impacta.microservices.contacorrente.client.DebitoClient;
import com.impacta.microservices.contacorrente.client.response.SaldoCredito;
import com.impacta.microservices.contacorrente.client.response.SaldoDebito;
import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.repository.ContaCorrenteRepository;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteService {

    private ContaCorrenteRepository repository;
    private CreditoClient creditoClient;
    private DebitoClient debitoClient;


    public ContaCorrenteService(ContaCorrenteRepository repository,
                               CreditoClient creditoClient,
                               DebitoClient debitoClient) {
        this.repository = repository;
        this.creditoClient = creditoClient;
        this.debitoClient = debitoClient;
    }

    public ContaCorrente criarContaCorrente(ContaCorrente contaCorrente) {
        return repository.save(contaCorrente);
    }

    public ContaCorrente buscarContaCorrente(Integer contaId) {

        atualizaSaldo(contaId);
        return repository.findByContaId(contaId);
    }

    public Double consultaSaldoContaCorrente(Integer contaId) {

        //recupera valor total de credito da conta corrente
        SaldoCredito saldoCred = creditoClient.getSaldoCreditoConta(contaId);
        var saldoCredito = saldoCred.getValorCredito();

        //recupera valor total de debito da conta corrente
        SaldoDebito saldoDeb = debitoClient.getSaldoDebitoConta(contaId);
        var saldoDebito = saldoDeb.getSaldoDebito();

        //realiza abatimento do total de credito pelo debito para obter o valor atual do saldo
        var saldoTotal = saldoCredito - saldoDebito;

        return saldoTotal;
    }

    public void atualizaSaldo(Integer contaId){

        //Atualiza tabela de conta corrente com o saldo obtido
        var contacorrente = repository.findByContaId(contaId);
        contacorrente.setSaldo(consultaSaldoContaCorrente(contaId));
        repository.save(contacorrente);

    }

}
