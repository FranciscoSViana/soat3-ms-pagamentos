package com.techchallenge.soat3mspagamentos.domain.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class I18nTest {

    @Test
    void pagamentoNaoLocalizado_ShouldReturnExpectedString() {
        String id = "123";

        String result = I18n.PAGAMENTO_NAO_LOCALIZADO;

        assertEquals("Pagamento nao foi localizado para o id: %s", result);
    }

    @Test
    void erroPagamentoMp_ShouldReturnExpectedString() {
        String id = "456";

        String result = I18n.ERRO_PAGAMENTO_MP;

        assertEquals("Houve erro com conexao com mp - id: %s", result);
    }
}
