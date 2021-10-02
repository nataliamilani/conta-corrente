package com.impacta.microservices.contacorrente.client.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoDebito {

    private Double valorDebito;

    @JsonCreator
    public SaldoDebito(@JsonProperty("saldoDebito") Double valorDebito){
        this.valorDebito = valorDebito;
    }

    public Double getSaldoDebito() {return valorDebito;}

}