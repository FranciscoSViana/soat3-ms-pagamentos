package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PagadorMPTest {

    private PagadorMP pagador;

    @BeforeEach
    public void setUp() {
        pagador = PagadorMP.builder()
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
                .build();
    }

    @Test
    public void testConstructorWithFields() {
        assertNotNull(pagador);
        assertEquals("pagador@example.com", pagador.getEmail());
        assertEquals("João", pagador.getNome());
        assertEquals("da Silva", pagador.getSobreNome());

        assertNotNull(pagador.getIdentification());
        assertEquals("RG", pagador.getIdentification().getTipoDocumento());
        assertEquals("123456789", pagador.getIdentification().getNumeroDocumento());

        assertNotNull(pagador.getAddress());
        assertEquals("12345-678", pagador.getAddress().getCep());
        assertEquals("Rua Principal", pagador.getAddress().getRua());
        assertEquals("123", pagador.getAddress().getNumeroRua());
        assertEquals("Centro", pagador.getAddress().getNeighborhood());
        assertEquals("Cidade", pagador.getAddress().getCidade());
        assertEquals("UF", pagador.getAddress().getUf());
    }

    @Test
    public void testSettersAndGetters() {
        pagador.setEmail("novoemail@example.com");
        assertEquals("novoemail@example.com", pagador.getEmail());

        pagador.setNome("Maria");
        assertEquals("Maria", pagador.getNome());

        pagador.setSobreNome("Souza");
        assertEquals("Souza", pagador.getSobreNome());

        IdentificacaoMP novaIdentificacao = IdentificacaoMP.builder()
                .tipoDocumento("CPF")
                .numeroDocumento("987654321")
                .build();
        pagador.setIdentification(novaIdentificacao);
        assertEquals(novaIdentificacao, pagador.getIdentification());

        EnderecoMP novoEndereco = EnderecoMP.builder()
                .cep("98765-432")
                .rua("Avenida Central")
                .numeroRua("456")
                .neighborhood("Bairro Novo")
                .cidade("Outra Cidade")
                .uf("OUT")
                .build();
        pagador.setAddress(novoEndereco);
        assertEquals(novoEndereco, pagador.getAddress());
    }

    @Test
    public void testNullValues() {
        PagadorMP pagadorNulo = new PagadorMP();

        assertNull(pagadorNulo.getEmail());
        assertNull(pagadorNulo.getNome());
        assertNull(pagadorNulo.getSobreNome());
        assertNull(pagadorNulo.getIdentification());
        assertNull(pagadorNulo.getAddress());

        pagadorNulo.setEmail(null);
        pagadorNulo.setNome(null);
        pagadorNulo.setSobreNome(null);
        pagadorNulo.setIdentification(null);
        pagadorNulo.setAddress(null);

        assertNull(pagadorNulo.getEmail());
        assertNull(pagadorNulo.getNome());
        assertNull(pagadorNulo.getSobreNome());
        assertNull(pagadorNulo.getIdentification());
        assertNull(pagadorNulo.getAddress());
    }

    @Test
    public void testBuilder() {
        assertNotNull(PagadorMP.builder());
    }
}
