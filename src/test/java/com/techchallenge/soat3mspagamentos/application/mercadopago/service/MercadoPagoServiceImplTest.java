package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.techchallenge.soat3mspagamentos.adapter.mercadopago.MercadoPagoClient;
import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.ClienteModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.evento.PagamentoProducer;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.commons.utils.JsonUtil;
import com.techchallenge.soat3mspagamentos.domain.model.enumerate.StatusPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class MercadoPagoServiceImplTest {

    @Mock
    private MercadoPagoClient mercadoPagoClient;

    @Mock
    private JsonUtil jsonUtil;

    @Mock
    private PagamentoProducer produtor;

    @InjectMocks
    private MercadoPagoServiceImpl mercadoPagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarPagamento_DeveRetornarPagamentoComId() {

        PagamentoModel pagamento = PagamentoModel.builder()
                .id(UUID.randomUUID())
                .cliente(ClienteModel.builder().email("teste@teste.br").build())
                .preco(BigDecimal.TEN)
                .statusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO)
                .qrCode("some_qr_code".getBytes())
                .build();

        String response = "{\"qr_code\": \"some_qr_code\", \"qr_code_base64\": \"base_64_image\", \"id\": \"123456\",\"description\": \"us456asd59s\"}";

        when(mercadoPagoClient.criarPagamento(any(), any())).thenReturn(response);
        when(jsonUtil.obterValorChaveJson(eq(response), eq("qr_code"))).thenReturn("some_qr_code");
        when(jsonUtil.obterValorChaveJson(eq(response), eq("qr_code_base64"))).thenReturn("base_64_image");
        when(jsonUtil.obterValorChaveJson(eq(response), eq("id"))).thenReturn("123456");
        when(jsonUtil.obterValorChaveJson(eq(response), eq("description"))).thenReturn("us456asd59s");

        when(mercadoPagoClient.confirmarPagamento(any(), any())).thenReturn("123456");

        mercadoPagoService.criarPagamento(pagamento);

        assertEquals("123456", pagamento.getIdPagamentoMP());
        assertEquals("some_qr_code", pagamento.getCodigoPix());
        assertEquals("base_64_image", new String(pagamento.getQrCode()));
    }
}
