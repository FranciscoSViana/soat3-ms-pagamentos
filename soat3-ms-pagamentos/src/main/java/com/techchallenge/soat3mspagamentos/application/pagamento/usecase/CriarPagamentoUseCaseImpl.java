package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CriarPagamentoUseCaseImpl implements  CriarPagamentoUseCase {

    private final MercadoPagoService mercadoPagoService;

    @Override
    public PagamentoModel criarPagamento(PagamentoModel request) {
        return mercadoPagoService.criarPagamento(request);
    }
}
