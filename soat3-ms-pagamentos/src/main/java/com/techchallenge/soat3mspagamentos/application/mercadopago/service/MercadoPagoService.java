package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;

public interface MercadoPagoService {

    PagamentoModel criarPagamento(PagamentoModel pagamento);

    PagamentoModel confirmarPagamento(Long idPagamento);

}
