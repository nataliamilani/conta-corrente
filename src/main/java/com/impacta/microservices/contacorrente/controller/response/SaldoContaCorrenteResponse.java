package com.impacta.microservices.contacorrente.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoContaCorrenteResponse {

    private Double saldoContaCorrente;

    public SaldoContaCorrenteResponse(@JsonProperty("saldo_contacorrente") Double saldo){
        this.saldoContaCorrente = saldo;
    }

    public Double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    public void setSaldoContaCorrente(Double saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }

}
