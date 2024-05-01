package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PagamentoMPRequestTest {

    private PagamentoMPRequest pagamento;

    @BeforeEach
    public void setUp() {
        pagamento = PagamentoMPRequest.builder()
                .valor(BigDecimal.valueOf(100.00))
                .descricao("Compra de produto")
                .metodoDePagamento("credit_card")
                .enderecoNotificacao("https://example.com/notification")
                .payer(PagadorMP.builder()
                        .email("pagador@example.com")
                        .nome("João")
                        .sobreNome("da Silva")
                        .identification(IdentificacaoMP.builder()
                                .tipoDocumento("RG")
                                .numeroDocumento("123456789")
                                .build())
                        .address(EnderecoMP.builder()
                                .cep("12345-678")
                                .rua("Rua Principal")
                                .numeroRua("123")
                                .neighborhood("Centro")
                                .cidade("Cidade")
                                .uf("UF")
                                .build())
                        .build())
                .build();
    }

    @Test
    public void testConstructorWithFields() {
        assertNotNull(pagamento);
        assertEquals(BigDecimal.valueOf(100.00), pagamento.getValor());
        assertEquals("Compra de produto", pagamento.getDescricao());
        assertEquals("credit_card", pagamento.getMetodoDePagamento());
        assertEquals("https://example.com/notification", pagamento.getEnderecoNotificacao());

        assertNotNull(pagamento.getPayer());
        assertEquals("pagador@example.com", pagamento.getPayer().getEmail());
        assertEquals("João", pagamento.getPayer().getNome());
        assertEquals("da Silva", pagamento.getPayer().getSobreNome());

        assertNotNull(pagamento.getPayer().getIdentification());
        assertEquals("RG", pagamento.getPayer().getIdentification().getTipoDocumento());
        assertEquals("123456789", pagamento.getPayer().getIdentification().getNumeroDocumento());

        assertNotNull(pagamento.getPayer().getAddress());
        assertEquals("12345-678", pagamento.getPayer().getAddress().getCep());
        assertEquals("Rua Principal", pagamento.getPayer().getAddress().getRua());
        assertEquals("123", pagamento.getPayer().getAddress().getNumeroRua());
        assertEquals("Centro", pagamento.getPayer().getAddress().getNeighborhood());
        assertEquals("Cidade", pagamento.getPayer().getAddress().getCidade());
        assertEquals("UF", pagamento.getPayer().getAddress().getUf());
    }

    @Test
    public void testSettersAndGetters() {
        pagamento.setValor(BigDecimal.valueOf(200.00));
        assertEquals(BigDecimal.valueOf(200.00), pagamento.getValor());

        pagamento.setDescricao("Nova descrição");
        assertEquals("Nova descrição", pagamento.getDescricao());

        pagamento.setMetodoDePagamento("debit_card");
        assertEquals("debit_card", pagamento.getMetodoDePagamento());

        pagamento.setEnderecoNotificacao("https://example.com/new-notification");
        assertEquals("https://example.com/new-notification", pagamento.getEnderecoNotificacao());

        PagadorMP novoPagador = PagadorMP.builder()
                .email("novoemail@example.com")
                .nome("Maria")
                .sobreNome("Souza")
                .identification(IdentificacaoMP.builder()
                        .tipoDocumento("CPF")
                        .numeroDocumento("987654321")
                        .build())
                .address(EnderecoMP.builder()
                        .cep("98765-432")
                        .rua("Avenida Central")
                        .numeroRua("456")
                        .neighborhood("Bairro Novo")
                        .cidade("Outra Cidade")
                        .uf("OUT")
                        .build())
                .build();
        pagamento.setPayer(novoPagador);
        assertEquals(novoPagador, pagamento.getPayer());
    }

    @Test
    public void testNullValues() {
        PagamentoMPRequest pagamentoNulo = new PagamentoMPRequest();

        assertNull(pagamentoNulo.getValor());
        assertNull(pagamentoNulo.getDescricao());
        assertNull(pagamentoNulo.getMetodoDePagamento());
        assertNull(pagamentoNulo.getEnderecoNotificacao());
        assertNull(pagamentoNulo.getPayer());

        pagamentoNulo.setValor(null);
        pagamentoNulo.setDescricao(null);
        pagamentoNulo.setMetodoDePagamento(null);
        pagamentoNulo.setEnderecoNotificacao(null);
        pagamentoNulo.setPayer(null);

        assertNull(pagamentoNulo.getValor());
        assertNull(pagamentoNulo.getDescricao());
        assertNull(pagamentoNulo.getMetodoDePagamento());
        assertNull(pagamentoNulo.getEnderecoNotificacao());
        assertNull(pagamentoNulo.getPayer());
    }

    @Test
    public void testBuilder() {
        assertNotNull(PagamentoMPRequest.builder());
    }
}
