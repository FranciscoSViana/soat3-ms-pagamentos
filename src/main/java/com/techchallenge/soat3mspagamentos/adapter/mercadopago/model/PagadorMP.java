package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagadorMP {

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String nome;

    @JsonProperty("last_name")
    private String sobreNome;

    private IdentificacaoMP identification;

    private EnderecoMP address;


}
