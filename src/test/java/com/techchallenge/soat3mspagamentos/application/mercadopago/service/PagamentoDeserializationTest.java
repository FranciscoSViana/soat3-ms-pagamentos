package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PagamentoDeserializationTest {

    @Test
    public void testPagamentoDeserialization() throws Exception {
        String json = "{\"id\":\"ca9d304b-6cc2-480d-b64e-2417cbf354c4\",\"cliente\":{\"id\":\"eb2a8344-51fd-4490-9db4-8c42398f9e21\",\"nome\":\"João Silva\",\"cpf\":\"12345678909\",\"email\":\"joao.silva@example.com\",\"telefone\":\"11999999999\"},\"preco\":100.00,\"statusPagamento\":\"AGUARDANDO_PAGAMENTO\",\"codigoPix\":\"codigo-pix-exemplo\",\"idPagamentoMP\":null,\"qrCode\":\"\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        PagamentoModel pagamento = objectMapper.readValue(json, PagamentoModel.class);

        assertNotNull(pagamento);
    }
}
