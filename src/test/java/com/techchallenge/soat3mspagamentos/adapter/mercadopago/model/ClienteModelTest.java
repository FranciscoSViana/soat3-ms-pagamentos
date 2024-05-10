package com.techchallenge.soat3mspagamentos.adapter.mercadopago.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ClienteModelTest {

    private ClienteModel cliente1;
    private ClienteModel cliente2;

    @BeforeEach
    void setUp() {
        cliente1 = ClienteModel.builder()
                .id(UUID.randomUUID())
                .nome("João da Silva")
                .cpf("123.456.789-00")
                .email("joao@example.com")
                .telefone("123456789")
                .build();

        cliente2 = ClienteModel.builder()
                .id(UUID.randomUUID())
                .nome("Maria Souza")
                .cpf("987.654.321-00")
                .email("maria@example.com")
                .telefone("987654321")
                .build();
    }

    @Test
    void testConstructorWithFields() {
        assertNotNull(cliente1);
        assertNotNull(cliente1.getId());
        assertEquals("João da Silva", cliente1.getNome());
        assertEquals("123.456.789-00", cliente1.getCpf());
        assertEquals("joao@example.com", cliente1.getEmail());
        assertEquals("123456789", cliente1.getTelefone());
    }

    @Test
    void testSettersAndGetters() {
        UUID newId = UUID.randomUUID();
        cliente1.setId(newId);
        assertEquals(newId, cliente1.getId());

        cliente1.setNome("Maria Souza");
        assertEquals("Maria Souza", cliente1.getNome());

        cliente1.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", cliente1.getCpf());

        cliente1.setEmail("maria@example.com");
        assertEquals("maria@example.com", cliente1.getEmail());

        cliente1.setTelefone("987654321");
        assertEquals("987654321", cliente1.getTelefone());
    }

    @Test
    void testEquality() {
        assertEquals(cliente1, cliente1);

        assertNotEquals(cliente1, cliente2);

        ClienteModel cliente3 = ClienteModel.builder()
                .id(UUID.randomUUID())
                .nome("João da Silva")
                .cpf("123.456.789-00")
                .email("joao@example.com")
                .telefone("123456789")
                .build();
        assertNotEquals(cliente1, cliente3);
    }

    @Test
    void testNullValues() {
        ClienteModel clienteNulo = new ClienteModel();

        assertNull(clienteNulo.getId());
        assertNull(clienteNulo.getNome());
        assertNull(clienteNulo.getCpf());
        assertNull(clienteNulo.getEmail());
        assertNull(clienteNulo.getTelefone());

        clienteNulo.setId(null);
        clienteNulo.setNome(null);
        clienteNulo.setCpf(null);
        clienteNulo.setEmail(null);
        clienteNulo.setTelefone(null);

        assertNull(clienteNulo.getId());
        assertNull(clienteNulo.getNome());
        assertNull(clienteNulo.getCpf());
        assertNull(clienteNulo.getEmail());
        assertNull(clienteNulo.getTelefone());
    }

    @Test
    void testBuilder() {
        assertNotNull(ClienteModel.builder());
    }
}
