package com.techchallenge.soat3mspagamentos.adapter.pagamento.model;

import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.ClienteModel;
import com.techchallenge.soat3mspagamentos.domain.model.enumerate.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoModel {

    private UUID id;

    private ClienteModel cliente;

    private BigDecimal preco;

    private StatusPagamento statusPagamento;

    private String codigoPix;

    private String idPagamentoMP;

    private byte[] qrCode;

}
