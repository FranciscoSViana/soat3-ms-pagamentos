package com.techchallenge.soat3mspagamentos.adapter.pagamento.model;

import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.ClienteModel;
import com.techchallenge.soat3mspagamentos.domain.model.enumerate.StatusPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PagamentoModelTest {

    private PagamentoModel pagamento;

    @BeforeEach
    public void setUp() {
        pagamento = PagamentoModel.builder()
                .id(UUID.randomUUID())
                .cliente(ClienteModel.builder()
                        .id(UUID.randomUUID())
                        .nome("João da Silva")
                        .cpf("123.456.789-00")
                        .email("joao@example.com")
                        .telefone("123456789")
                        .build())
                .preco(BigDecimal.valueOf(100))
                .statusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO)
                .codigoPix("ABC123")
                .idPagamentoMP("MP123")
                .qrCode(new byte[]{1, 2, 3, 4, 5})
                .build();
    }

    @Test
    public void testConstructorWithFields() {
        assertNotNull(pagamento);
        assertNotNull(pagamento.getId());
        assertNotNull(pagamento.getCliente());
        assertNotNull(pagamento.getPreco());
        assertNotNull(pagamento.getStatusPagamento());
        assertNotNull(pagamento.getCodigoPix());
        assertNotNull(pagamento.getIdPagamentoMP());
        assertNotNull(pagamento.getQrCode());
    }

    @Test
    public void testSettersAndGetters() {
        UUID newId = UUID.randomUUID();
        pagamento.setId(newId);
        assertEquals(newId, pagamento.getId());

        ClienteModel newCliente = ClienteModel.builder()
                .id(UUID.randomUUID())
                .nome("Maria Souza")
                .cpf("987.654.321-00")
                .email("maria@example.com")
                .telefone("987654321")
                .build();
        pagamento.setCliente(newCliente);
        assertEquals(newCliente, pagamento.getCliente());

        BigDecimal newPreco = BigDecimal.valueOf(200);
        pagamento.setPreco(newPreco);
        assertEquals(newPreco, pagamento.getPreco());

        StatusPagamento newStatus = StatusPagamento.PAGO;
        pagamento.setStatusPagamento(newStatus);
        assertEquals(newStatus, pagamento.getStatusPagamento());

        String newCodigoPix = "XYZ789";
        pagamento.setCodigoPix(newCodigoPix);
        assertEquals(newCodigoPix, pagamento.getCodigoPix());

        String newIdPagamentoMP = "MP456";
        pagamento.setIdPagamentoMP(newIdPagamentoMP);
        assertEquals(newIdPagamentoMP, pagamento.getIdPagamentoMP());

        byte[] newQrCode = {6, 7, 8, 9, 10};
        pagamento.setQrCode(newQrCode);
        assertEquals(newQrCode, pagamento.getQrCode());
    }

    @Test
    public void testNullValues() {
        PagamentoModel pagamentoNulo = new PagamentoModel();

        assertNull(pagamentoNulo.getId());
        assertNull(pagamentoNulo.getCliente());
        assertNull(pagamentoNulo.getPreco());
        assertNull(pagamentoNulo.getStatusPagamento());
        assertNull(pagamentoNulo.getCodigoPix());
        assertNull(pagamentoNulo.getIdPagamentoMP());
        assertNull(pagamentoNulo.getQrCode());

        pagamentoNulo.setId(null);
        pagamentoNulo.setCliente(null);
        pagamentoNulo.setPreco(null);
        pagamentoNulo.setStatusPagamento(null);
        pagamentoNulo.setCodigoPix(null);
        pagamentoNulo.setIdPagamentoMP(null);
        pagamentoNulo.setQrCode(null);

        assertNull(pagamentoNulo.getId());
        assertNull(pagamentoNulo.getCliente());
        assertNull(pagamentoNulo.getPreco());
        assertNull(pagamentoNulo.getStatusPagamento());
        assertNull(pagamentoNulo.getCodigoPix());
        assertNull(pagamentoNulo.getIdPagamentoMP());
        assertNull(pagamentoNulo.getQrCode());
    }

    @Test
    public void testBuilder() {
        assertNotNull(PagamentoModel.builder());
    }
}
