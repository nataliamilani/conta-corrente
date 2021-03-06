package com.impacta.microservices.contacorrente.client;

import com.impacta.microservices.contacorrente.client.request.CriarCreditoRequest;
import com.impacta.microservices.contacorrente.client.response.SaldoCredito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "credito", url = "${clients.credito}")
public interface CreditoClient {

    @GetMapping(value = "/saldo/contacorrente/{contaId}")
    SaldoCredito getSaldoCreditoConta(@PathVariable("contaId") Integer contaId);

    @PostMapping()
    CriarCreditoRequest criarCredito(@RequestBody CriarCreditoRequest creditoRequest);
}
