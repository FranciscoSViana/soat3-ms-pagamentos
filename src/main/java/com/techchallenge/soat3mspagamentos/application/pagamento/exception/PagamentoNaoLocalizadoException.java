package com.techchallenge.soat3mspagamentos.application.pagamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PagamentoNaoLocalizadoException extends RuntimeException {
    public PagamentoNaoLocalizadoException(String message) {
        super(message);
    }

}
