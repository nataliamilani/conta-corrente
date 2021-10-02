package com.impacta.microservices.contacorrente.controller.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoContaCorrenteResponse {

    private Double saldoContaCorrente;

    @JsonCreator
    public SaldoContaCorrenteResponse(@JsonProperty("saldo_conta_corrente") Double saldo){
        this.saldoContaCorrente = saldo;
    }

    public Double getSaldoContaCorrente() {
        return saldoContaCorrente;
    }

    public void setSaldoContaCorrente(Double saldoContaCorrente) {
        this.saldoContaCorrente = saldoContaCorrente;
    }

}
