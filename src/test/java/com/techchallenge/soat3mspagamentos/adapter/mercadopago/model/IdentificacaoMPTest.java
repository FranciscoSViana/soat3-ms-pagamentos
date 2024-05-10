package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IdentificacaoMPTest {

    private IdentificacaoMP identificacao;

    @BeforeEach
    void setUp() {
        identificacao = IdentificacaoMP.builder()
                .tipoDocumento("RG")
                .numeroDocumento("123456789")
                .build();
    }

    @Test
    void testConstructorWithFields() {
        assertNotNull(identificacao);
        assertEquals("RG", identificacao.getTipoDocumento());
        assertEquals("123456789", identificacao.getNumeroDocumento());
    }

    @Test
    void testSettersAndGetters() {
        identificacao.setTipoDocumento("CPF");
        assertEquals("CPF", identificacao.getTipoDocumento());

        identificacao.setNumeroDocumento("987654321");
        assertEquals("987654321", identificacao.getNumeroDocumento());
    }

    @Test
    void testNullValues() {
        IdentificacaoMP identificacaoNula = new IdentificacaoMP();

        assertNull(identificacaoNula.getTipoDocumento());
        assertNull(identificacaoNula.getNumeroDocumento());

        identificacaoNula.setTipoDocumento(null);
        identificacaoNula.setNumeroDocumento(null);

        assertNull(identificacaoNula.getTipoDocumento());
        assertNull(identificacaoNula.getNumeroDocumento());
    }

    @Test
    void testBuilder() {
        assertNotNull(IdentificacaoMP.builder());
    }
}
