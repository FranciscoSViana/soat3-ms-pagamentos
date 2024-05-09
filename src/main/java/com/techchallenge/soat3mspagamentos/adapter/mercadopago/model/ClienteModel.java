package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteModel {

    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;


}
