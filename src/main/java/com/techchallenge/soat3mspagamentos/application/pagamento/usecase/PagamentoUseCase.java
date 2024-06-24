package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;

public interface PagamentoUseCase {
    void criarPagamento(PagamentoModel request);
    void confirmarPagamento(Long idPagamentoMP);


}
