package com.techchallenge.soat3mspagamentos.domain.model.enumerate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StatusPagamentoTest {

    @Test
    void fromName_ValidName_ShouldReturnCorrectEnum() {
        String name = "PAGO";

        StatusPagamento result = StatusPagamento.fromName(name);

        assertEquals(StatusPagamento.PAGO, result);
    }

    @Test
    void fromName_InvalidName_ShouldThrowException() {
        String name = "INVALIDO";

        assertThrows(IllegalArgumentException.class, () -> {
            StatusPagamento.fromName(name);
        });
    }

    @Test
    void fromName_IgnoreCase_ShouldReturnCorrectEnum() {
        String name = "AGUARDANDO_PAGAMENTO";

        StatusPagamento result = StatusPagamento.fromName(name);

        assertEquals(StatusPagamento.AGUARDANDO_PAGAMENTO, result);
    }
}
