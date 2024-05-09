package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PagamentoMPRequest {

    @JsonProperty("transaction_amount")
    private BigDecimal valor;

    @JsonProperty("description")
    private String descricao;

    @JsonProperty("payment_method_id")
    private String metodoDePagamento;

    @JsonProperty("notification_url")
    private String enderecoNotificacao;

    private PagadorMP payer;

}
