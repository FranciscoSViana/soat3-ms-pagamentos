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
public class EnderecoMP {

    @JsonProperty("zip_code")
    private String cep;

    @JsonProperty("street_name")
    private String rua;

    @JsonProperty("street_number")
    private String numeroRua;

    @JsonProperty("neighborhood")
    private String neighborhood;

    @JsonProperty("city")
    private String cidade;

    @JsonProperty("federal_unit")
    private String uf;
}
