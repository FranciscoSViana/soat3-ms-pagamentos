package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnderecoMPTest {

    private EnderecoMP endereco;

    @BeforeEach
    public void setUp() {
        endereco = EnderecoMP.builder()
                .cep("12345-678")
                .rua("Rua Principal")
                .numeroRua("123")
                .neighborhood("Centro")
                .cidade("Cidade")
                .uf("UF")
                .build();
    }

    @Test
    public void testConstructorWithFields() {
        assertNotNull(endereco);
        assertEquals("12345-678", endereco.getCep());
        assertEquals("Rua Principal", endereco.getRua());
        assertEquals("123", endereco.getNumeroRua());
        assertEquals("Centro", endereco.getNeighborhood());
        assertEquals("Cidade", endereco.getCidade());
        assertEquals("UF", endereco.getUf());
    }

    @Test
    public void testSettersAndGetters() {
        endereco.setCep("98765-432");
        assertEquals("98765-432", endereco.getCep());

        endereco.setRua("Avenida Central");
        assertEquals("Avenida Central", endereco.getRua());

        endereco.setNumeroRua("456");
        assertEquals("456", endereco.getNumeroRua());

        endereco.setNeighborhood("Bairro Novo");
        assertEquals("Bairro Novo", endereco.getNeighborhood());

        endereco.setCidade("Outra Cidade");
        assertEquals("Outra Cidade", endereco.getCidade());

        endereco.setUf("OUT");
        assertEquals("OUT", endereco.getUf());
    }

    @Test
    public void testNullValues() {
        EnderecoMP enderecoNulo = new EnderecoMP();

        assertNull(enderecoNulo.getCep());
        assertNull(enderecoNulo.getRua());
        assertNull(enderecoNulo.getNumeroRua());
        assertNull(enderecoNulo.getNeighborhood());
        assertNull(enderecoNulo.getCidade());
        assertNull(enderecoNulo.getUf());

        enderecoNulo.setCep(null);
        enderecoNulo.setRua(null);
        enderecoNulo.setNumeroRua(null);
        enderecoNulo.setNeighborhood(null);
        enderecoNulo.setCidade(null);
        enderecoNulo.setUf(null);

        assertNull(enderecoNulo.getCep());
        assertNull(enderecoNulo.getRua());
        assertNull(enderecoNulo.getNumeroRua());
        assertNull(enderecoNulo.getNeighborhood());
        assertNull(enderecoNulo.getCidade());
        assertNull(enderecoNulo.getUf());
    }

    @Test
    public void testBuilder() {
        assertNotNull(EnderecoMP.builder());
    }
}
