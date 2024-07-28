package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PagamentoUseCaseImpl implements PagamentoUseCase{

    private final CriarPagamentoUseCase criarPagamentoUseCase;

    private final ConfirmarPagamentoUseCase confirmarPagamentoUseCase;

    @Override
    public void criarPagamento(PagamentoModel request) {
        criarPagamentoUseCase.criarPagamento(request);
    }

    @Override
    public void confirmarPagamento(Long idPagamentoMP) {
         confirmarPagamentoUseCase.confirmarPagamento(idPagamentoMP);
    }
}
