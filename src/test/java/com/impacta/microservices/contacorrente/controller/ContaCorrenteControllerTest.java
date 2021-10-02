package com.impacta.microservices.contacorrente.controller;

import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.service.ContaCorrenteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ContaCorrenteControllerTest {

    @Autowired
    private TestRestTemplate template;

    @MockBean
    private ContaCorrenteService contaCorrenteService;

    @Test
    public void aoCriarContaCorrenteRetornarContaCriada(){
        final Integer contaId = 1;
        final double saldo = 0.0;
        final Integer clienteId = 1;
        final ContaCorrente contaCorrente = new ContaCorrente(1, contaId, clienteId, saldo);

        when(contaCorrenteService.criarContaCorrente(contaCorrente)).thenReturn(contaCorrente);

        final ResponseEntity<ContaCorrente> response = template
                .postForEntity("/conta-corrente", contaCorrente, ContaCorrente.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void aoBuscarPorContaIdExibirContaCorrenteEncontrada(){
        final Integer contaId = 1;
        final double saldo = 20.0;
        final Integer clienteId = 1;
        final ContaCorrente contaCorrente = new ContaCorrente(1, contaId, clienteId, saldo);

        when(contaCorrenteService.buscarContaCorrente(contaId)).thenReturn(contaCorrente);

        final ResponseEntity<ContaCorrente> response = template
                .getForEntity("/conta-corrente/consulta/" + contaId, ContaCorrente.class );
        final ContaCorrente result = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(contaId, result.getContaId());
        assertEquals(clienteId, result.getClienteId());
    }
}
