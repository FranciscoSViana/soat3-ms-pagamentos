package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;

@FunctionalInterface
public interface ConfirmarPagamentoUseCase {
    PagamentoModel confirmarPagamento(Long idPagamentoMP);

}
