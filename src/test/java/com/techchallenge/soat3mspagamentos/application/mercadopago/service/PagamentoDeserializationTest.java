package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class PagamentoDeserializationTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testDeserialization() throws Exception {
        String json = "{\"id\":\"47d2d326-1479-469c-9df9-f16cb9060d2d\",\"cliente\":{\"id\":\"8b1910d4-046c-4d7a-b0f5-8f4d1c6db6e4\",\"nome\":\"Carlos Souza\",\"cpf\":\"45678912334\",\"email\":\"carlos.souza@example.com\",\"telefone\":\"31977777777\",\"dataHoraCriacao\":\"2024-06-25T05:32:43\",\"dataHoraAlteracao\":null,\"situacao\":true},\"preco\":1234.45,\"statusPagamento\":\"AGUARDANDO_PAGAMENTO\",\"codigoPix\":null,\"idPagamentoMP\":null,\"qrCode\":null}";

        PagamentoModel pagamento = objectMapper.readValue(json, PagamentoModel.class);

        assertThat(pagamento).isNotNull();
        assertThat(pagamento.getId()).isNotNull();
        assertThat(pagamento.getCliente()).isNotNull();
        assertThat(pagamento.getPreco()).isEqualByComparingTo("1234.45");
        assertThat(pagamento.getStatusPagamento()).isNotNull();
    }
}
