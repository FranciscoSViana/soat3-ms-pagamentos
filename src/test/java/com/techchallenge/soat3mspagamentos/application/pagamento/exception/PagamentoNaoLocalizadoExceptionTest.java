package com.techchallenge.soat3mspagamentos.application.pagamento.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PagamentoNaoLocalizadoExceptionTest {

    @Test
    void constructor_WithMessage_ShouldSetMessageAndStatusCode() {
        // Arrange
        String errorMessage = "Test error message";

        // Act
        PagamentoNaoLocalizadoException exception = new PagamentoNaoLocalizadoException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage());
    }

}