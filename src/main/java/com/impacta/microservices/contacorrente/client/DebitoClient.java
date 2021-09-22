package com.impacta.microservices.contacorrente.client;

import com.impacta.microservices.contacorrente.client.response.SaldoDebito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "debito", url = "${clients.debito}")
public interface DebitoClient {

    @GetMapping(value = "/saldo/contacorrente/{contaId}")
    SaldoDebito getSaldoDebitoConta(@PathVariable("contaId") Integer contaId);
}
