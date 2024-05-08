package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PagamentoUseCaseImpl implements PagamentoUseCase{

    private final CriarPagamentoUseCase criarPagamentoUseCase;

    private final ConfirmarPagamentoUseCase confirmarPagamentoUseCase;

    @Override
    public PagamentoModel criarPagamento(PagamentoModel request) {
        return criarPagamentoUseCase.criarPagamento(request);
    }

    @Override
    public PagamentoModel confirmarPagamento(Long idPagamentoMP) {
        return confirmarPagamentoUseCase.confirmarPagamento(idPagamentoMP);
    }
}
