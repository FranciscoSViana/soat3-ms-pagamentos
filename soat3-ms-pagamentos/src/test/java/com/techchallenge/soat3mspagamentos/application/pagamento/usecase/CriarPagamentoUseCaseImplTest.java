package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;


import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.NegocioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CriarPagamentoUseCaseImplTest {

    @Mock
    private MercadoPagoService mercadoPagoService;

    @InjectMocks
    private CriarPagamentoUseCaseImpl criarPagamentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void criarPagamento_WhenSuccessful_ShouldReturnPagamentoModel() {
        PagamentoModel pagamentoModel = new PagamentoModel();
        when(mercadoPagoService.criarPagamento(any())).thenReturn(pagamentoModel);

        PagamentoModel result = criarPagamentoUseCase.criarPagamento(new PagamentoModel());

        assertNotNull(result);
        assertEquals(pagamentoModel, result);
        verify(mercadoPagoService, times(1)).criarPagamento(any());
    }

    @Test
    void criarPagamento_WhenMercadoPagoServiceThrowsException_ShouldThrowNegocioException() {
        when(mercadoPagoService.criarPagamento(any())).thenThrow(new RuntimeException());

        assertThrows(NegocioException.class, () -> {
            criarPagamentoUseCase.criarPagamento(new PagamentoModel());
        });
    }
}
