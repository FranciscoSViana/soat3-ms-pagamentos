package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ClienteModel {

    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;


}
