package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;

@FunctionalInterface
public interface CriarPagamentoUseCase {

    void criarPagamento(PagamentoModel request);
}
