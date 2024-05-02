package com.techchallenge.soat3mspagamentos.application.pagamento.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NegocioExceptionTest {

    @Test
    void constructor_WithMessage_ShouldSetMessageAndStatusCode() {
        // Arrange
        String errorMessage = "Test error message";

        // Act
        NegocioException negocioException = new NegocioException(errorMessage);

        // Assert
        assertEquals(errorMessage, negocioException.getMessage());
    }


}