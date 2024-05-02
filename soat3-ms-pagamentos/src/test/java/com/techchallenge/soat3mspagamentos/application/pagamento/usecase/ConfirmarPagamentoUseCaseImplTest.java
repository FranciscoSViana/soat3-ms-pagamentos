package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.PagamentoNaoLocalizadoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ConfirmarPagamentoUseCaseImplTest {

    @Mock
    private MercadoPagoService mercadoPagoService;

    @InjectMocks
    private ConfirmarPagamentoUseCaseImpl confirmarPagamentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void confirmarPagamento_WhenSuccessful_ShouldReturnPagamentoModel() {
        PagamentoModel pagamentoModel = new PagamentoModel();
        when(mercadoPagoService.confirmarPagamento(anyLong())).thenReturn(pagamentoModel);

        PagamentoModel result = confirmarPagamentoUseCase.confirmarPagamento(123L);

        assertNotNull(result);
        assertEquals(pagamentoModel, result);
        verify(mercadoPagoService, times(1)).confirmarPagamento(anyLong());
    }

    @Test
    void confirmarPagamento_WhenMercadoPagoServiceThrowsException_ShouldThrowPagamentoNaoLocalizadoException() {
        when(mercadoPagoService.confirmarPagamento(anyLong())).thenThrow(new RuntimeException());

        assertThrows(PagamentoNaoLocalizadoException.class, () -> {
            confirmarPagamentoUseCase.confirmarPagamento(123L);
        });
    }
}
