package com.impacta.microservices.contacorrente.client;

import com.impacta.microservices.contacorrente.client.response.SaldoCredito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "credito", url = "http://localhost:8081/credito")
public interface CreditoClient {

    @RequestMapping(value = "/saldo/contacorrente/{contaId}", method = RequestMethod.GET)
    SaldoCredito getSaldoCreditoConta(@PathVariable("contaId") Integer contaId);
}