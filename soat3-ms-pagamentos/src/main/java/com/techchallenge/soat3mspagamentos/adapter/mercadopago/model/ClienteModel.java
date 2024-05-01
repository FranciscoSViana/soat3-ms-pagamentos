package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteModel {

    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;


}
