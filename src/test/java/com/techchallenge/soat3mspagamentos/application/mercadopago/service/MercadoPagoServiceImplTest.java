package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.techchallenge.soat3mspagamentos.adapter.mercadopago.MercadoPagoClient;
import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.ClienteModel;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
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

    @InjectMocks
    private MercadoPagoServiceImpl mercadoPagoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void criarPagamento_DeveRetornarPagamentoComId() {

        PagamentoModel pagamento = PagamentoModel.builder()
                .id(UUID.randomUUID())
                .cliente(ClienteModel.builder().email("teste@teste.br").build())
                .preco(BigDecimal.TEN)
                .statusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO)
                .codigoPix("123456")
                .idPagamentoMP("789")
                .build();

        String response = "{\"qr_code\": \"some_qr_code\", \"qr_code_base64\": \"base_64_image\", \"id\": \"some_id\"}";

        when(mercadoPagoClient.criarPagamento(any(), any())).thenReturn(response);

        when(jsonUtil.obterValorChaveJson(eq(response), eq("qr_code"))).thenReturn("some_qr_code");
        when(jsonUtil.obterValorChaveJson(eq(response), eq("qr_code_base64"))).thenReturn("base_64_image");
        when(jsonUtil.obterValorChaveJson(eq(response), eq("id"))).thenReturn("some_id");

        PagamentoModel result = mercadoPagoService.criarPagamento(pagamento);

        assertEquals(pagamento.getId(), result.getId());
    }


    @Test
    void confirmarPagamento_DeveRetornarPagamentoConfirmado() {
        Long idPagamento = 1L;
        String descricaoUUID = UUID.randomUUID().toString();
        String pagamentoMP = "{\"description\": \"" + descricaoUUID + "\"}";
        when(mercadoPagoClient.confirmarPagamento(any(), any())).thenReturn(pagamentoMP);
        when(jsonUtil.obterValorChaveJson(any(), any())).thenReturn(descricaoUUID);

        PagamentoModel result = mercadoPagoService.confirmarPagamento(idPagamento);

        assertEquals(StatusPagamento.PAGO, result.getStatusPagamento());
    }
}
