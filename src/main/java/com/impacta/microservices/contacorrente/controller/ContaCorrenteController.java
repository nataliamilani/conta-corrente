package com.impacta.microservices.contacorrente.controller;

import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.service.ContaCorrenteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ContaCorrente buscarContaCorrente(@PathVariable Integer contaId) {
        return contaCorrenteService.buscarContaCorrente(contaId);
    }
}
