package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PagamentoUseCaseImplTest {

    @Mock
    private CriarPagamentoUseCase criarPagamentoUseCase;

    @Mock
    private ConfirmarPagamentoUseCase confirmarPagamentoUseCase;

    @InjectMocks
    private PagamentoUseCaseImpl pagamentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void criarPagamento_ShouldCallCriarPagamentoUseCaseAndReturnResult() {
        PagamentoModel pagamentoModel = new PagamentoModel();
        when(criarPagamentoUseCase.criarPagamento(any())).thenReturn(pagamentoModel);

        PagamentoModel result = pagamentoUseCase.criarPagamento(new PagamentoModel());

        assertNotNull(result);
        verify(criarPagamentoUseCase, times(1)).criarPagamento(any());
    }

    @Test
    void confirmarPagamento_ShouldCallConfirmarPagamentoUseCaseAndReturnResult() {
        Long idPagamentoMP = 1L;
        PagamentoModel pagamentoModel = new PagamentoModel();
        when(confirmarPagamentoUseCase.confirmarPagamento(idPagamentoMP)).thenReturn(pagamentoModel);

        PagamentoModel result = pagamentoUseCase.confirmarPagamento(idPagamentoMP);

        assertNotNull(result);
        verify(confirmarPagamentoUseCase, times(1)).confirmarPagamento(idPagamentoMP);
    }
}
