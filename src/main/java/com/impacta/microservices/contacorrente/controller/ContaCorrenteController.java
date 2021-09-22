package com.impacta.microservices.contacorrente.controller;

import com.impacta.microservices.contacorrente.client.response.SaldoCredito;
import com.impacta.microservices.contacorrente.controller.response.SaldoContaCorrenteResponse;
import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.service.ContaCorrenteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.UnknownHostException;

@Tag(name= "Conta Corrente endpoints")
@RestController
@RequestMapping("/conta-corrente")
public class ContaCorrenteController {

    @Autowired
    private final ContaCorrenteService contaCorrenteService;

    public ContaCorrenteController(ContaCorrenteService contaCorrenteService) {
        this.contaCorrenteService = contaCorrenteService;
    }

    @GetMapping(path = "/status_aplicacao")
    public String checarStatusAplicacao(){
        return "Aplicação online";
    }

    @PostMapping
    public ContaCorrente criarContaCorrente(@RequestBody ContaCorrente contaCorrente) {
            return contaCorrenteService.criarContaCorrente(contaCorrente);

    }

    @GetMapping("/consulta/{contaId}")
    public ContaCorrente buscarContaCorrente(@PathVariable Integer contaId) throws UnknownHostException {
        ContaCorrente contaCorrente = contaCorrenteService.buscarContaCorrente(contaId);
        return contaCorrente;
    }

    @GetMapping("/saldo/{contaId}")
    public SaldoContaCorrenteResponse consultaSaldoContaCorrente(@PathVariable Integer contaId) throws UnknownHostException {
        SaldoContaCorrenteResponse saldo = new SaldoContaCorrenteResponse(contaCorrenteService.consultaSaldoContaCorrente(contaId));
        return saldo;
    }
}
