package com.techchallenge.soat3mspagamentos.application.pagamento.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.ClienteModel;
import com.techchallenge.soat3mspagamentos.domain.model.enumerate.StatusPagamento;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoModel {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("cliente")
    private ClienteModel cliente;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("statusPagamento")
    private StatusPagamento statusPagamento;

    @JsonProperty("codigoPix")
    private String codigoPix;

    @JsonProperty("idPagamentoMP")
    private String idPagamentoMP;

    @JsonProperty("qrCode")
    private byte[] qrCode;
}
