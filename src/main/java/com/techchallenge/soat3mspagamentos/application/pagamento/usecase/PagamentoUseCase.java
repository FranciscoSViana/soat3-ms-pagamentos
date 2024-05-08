package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;

public interface PagamentoUseCase {
    PagamentoModel criarPagamento(PagamentoModel request);
    PagamentoModel confirmarPagamento(Long idPagamentoMP);


}
