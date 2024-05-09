package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
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
