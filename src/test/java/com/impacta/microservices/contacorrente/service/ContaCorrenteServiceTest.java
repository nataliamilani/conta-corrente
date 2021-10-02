package com.impacta.microservices.contacorrente.service;

import com.impacta.microservices.contacorrente.client.CreditoClient;
import com.impacta.microservices.contacorrente.client.DebitoClient;
import com.impacta.microservices.contacorrente.domain.ContaCorrente;
import com.impacta.microservices.contacorrente.exceptions.ContaIdNotFoundException;
import com.impacta.microservices.contacorrente.repository.ContaCorrenteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = NONE)
class ContaCorrenteServiceTest {

    @InjectMocks
    private ContaCorrenteService contaCorrenteService;

    @Mock
    private ContaCorrenteRepository contaCorrenteRepository;

    @Mock
    private CreditoClient creditoClient;

    @Mock
    private DebitoClient debitoClient;

    @Before
    public void setUp() {
        contaCorrenteRepository.deleteAll();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void salvarContaCorrente() {
        final Integer contaId = 1;
        final double saldo = 0.0;
        final Integer clienteId = 1;
        final ContaCorrente contaCorrente = new ContaCorrente(1, contaId, clienteId, saldo);

        when(contaCorrenteRepository.save(contaCorrente)).thenReturn(contaCorrente);

        final ContaCorrente result = contaCorrenteService.criarContaCorrente(contaCorrente);

        assertEquals(contaId, result.getContaId());
        assertEquals(clienteId, result.getClienteId());
    }

//    @Test
//    public void buscarContaCorrente(){
//        final Integer contaId = 1;
//        final double saldo = 20.0;
//        final Integer clienteId = 1;
//        final ContaCorrente contacorrente = new ContaCorrente(1, contaId, clienteId, saldo);
//
//        final ContaCorrente result = contaCorrenteService.buscarContaCorrente(contacorrente.getContaId());
//
//        verify(contaCorrenteRepository, times(1)).findByContaId(contaId);
//        assertEquals(contaId, result.getContaId());
//        assertEquals(clienteId, result.getClienteId());
//    }

    @Test(expected = ContaIdNotFoundException.class)
    public void RetornarContaIdNotFoundExceptionQuandoBuscarContaIdInexistente(){
        when(contaCorrenteService.buscarContaCorrente(888)).thenThrow(ContaIdNotFoundException.class);
    }

//    @Test
//    public void atualizarSaldoContaCorrente(){
//        final Integer contaId = 1;
//        final double saldo = 0.0;
//        final Integer clienteId = 1;
//        final ContaCorrente contacorrente = new ContaCorrente(1, contaId, clienteId, saldo);
//
//        final ContaCorrente result = contaCorrenteService.atualizarSaldoContaCorrente(contaId);
//
//        verify(contaCorrenteRepository, times(1)).findByContaId(contaId);
//        verify(debitoClient, times(1)).getSaldoDebitoConta(contaId);
//        verify(creditoClient, times(1)).getSaldoCreditoConta(contaId);
//        verify(contaCorrenteRepository, times(1)).save(contacorrente);
//
//        assertEquals(contaId, result.getContaId());
//        assertThat(10.00).isEqualTo(result.getSaldo());
//    }


    @Test(expected = ContaIdNotFoundException.class)
    public void RetornarContaIdNotFoundExceptionQuandoTentarAtualizarContaIdInexistente(){
        when(contaCorrenteService.atualizarSaldoContaCorrente(888)).thenThrow(ContaIdNotFoundException.class);
    }
}
