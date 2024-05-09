package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
