package com.techchallenge.soat3mspagamentos.application.pagamento.exception;


import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void handleClienteNegocioException_ShouldReturnUnprocessableEntity() {
        // Arrange
        String errorMessage = "Test error message";
        NegocioException negocioException = new NegocioException(errorMessage);

        // Act
        ResponseEntity<String> responseEntity = exceptionHandler.handleClienteNegocioException(negocioException);

        // Assert
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }

    @Test
    void handleClienteNegocioException_ShouldReturnUnprocessableEntity_WithDefaultMessageIfNull() {
        // Arrange
        NegocioException negocioException = new NegocioException("NegocioException occurred");

        // Act
        ResponseEntity<String> responseEntity = exceptionHandler.handleClienteNegocioException(negocioException);

        // Assert
        assertEquals(HttpStatus.UNPROCESSABLE_ENTITY, responseEntity.getStatusCode());
        assertEquals("NegocioException occurred", responseEntity.getBody());
    }
}