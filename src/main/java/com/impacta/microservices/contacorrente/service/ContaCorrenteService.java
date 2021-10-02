package com.impacta.microservices.contacorrente.service;

import com.impacta.microservices.contacorrente.client.CreditoClient;
import com.impacta.microservices.contacorrente.client.DebitoClient;
import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.exceptions.ContaIdExistenteBadRequestException;
import com.impacta.microservices.contacorrente.exceptions.ContaIdNotFoundException;
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

        var contaExistente = repository.findByContaId(contaCorrente.getContaId()).isPresent();

        if(contaExistente) {
            throw new ContaIdExistenteBadRequestException("ContaId " + contaCorrente.getContaId() + " já existe");
        }
        return repository.save(contaCorrente);
    }

    public ContaCorrente buscarContaCorrente(Integer contaId) {
        atualizarSaldoContaCorrente(contaId);

        if(repository.findByContaId(contaId).isPresent()) {
            return repository.findByContaId(contaId).get();
        }
            return  null;
    }

    public ContaCorrente atualizarSaldoContaCorrente(Integer contaId) {
            var contaCorrente = repository.findByContaId(contaId)
                    .orElseThrow(() -> new ContaIdNotFoundException("Não encontrada conta id: " + contaId));

            var debito = debitoClient.getSaldoDebitoConta(contaId);
            var credito = creditoClient.getSaldoCreditoConta(contaId);

            double saldoTotalConta = credito.getValorCredito() - debito.getValorDebito();

            contaCorrente.setSaldo(saldoTotalConta);

            return repository.save(contaCorrente);
    }
}
