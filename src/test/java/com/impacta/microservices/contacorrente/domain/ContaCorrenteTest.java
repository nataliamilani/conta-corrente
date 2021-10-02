package com.impacta.microservices.contacorrente.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContaCorrenteTest {

    @Test
    public void CriarContaCorrente() {
        final Integer contaId = 1;
        final double saldo = 0.0;
        final Integer clienteId = 1;

        final ContaCorrente contaCorrente = new ContaCorrente(1, contaId, clienteId, saldo);

        assertEquals(contaId, contaCorrente.getContaId());
        assertEquals(saldo, contaCorrente.getSaldo());
        assertEquals(clienteId, contaCorrente.getClienteId());
    }
}
