package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdentificacaoMP {

    @JsonProperty("type")
    private String tipoDocumento;

    @JsonProperty("number")
    private String numeroDocumento;

}
