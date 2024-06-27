package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

@FunctionalInterface
public interface ConfirmarPagamentoUseCase {
    void confirmarPagamento(Long idPagamentoMP);

}
