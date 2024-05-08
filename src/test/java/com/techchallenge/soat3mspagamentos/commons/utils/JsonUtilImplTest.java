package com.techchallenge.soat3mspagamentos.commons.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class JsonUtilImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private JsonUtilImpl jsonUtil;

    @Test
    void obterValorChaveJson_ValidJsonAndKeyExists_ShouldReturnExpectedValue() throws Exception {
        String json = "{\"key1\": \"value1\", \"key2\": \"value2\"}";
        String chave = "key1";
        ObjectNode rootNode = new ObjectMapper().createObjectNode();
        rootNode.put("key1", "value1");
        when(objectMapper.readTree(anyString())).thenReturn(rootNode);

        String result = jsonUtil.obterValorChaveJson(json, chave);

        assertEquals("\"value1\"", result);
    }


    @Test
    void obterValorChaveJson_InvalidJson_ShouldReturnNull() throws Exception {
        String json = "invalid json";
        String chave = "key1";
        when(objectMapper.readTree(anyString())).thenThrow(new RuntimeException("Invalid JSON"));

        String result = jsonUtil.obterValorChaveJson(json, chave);

        assertNull(result);
    }

    @Test
    void obterValorChaveJson_NullJson_ShouldReturnNull() throws Exception {
        String chave = "key1";

        String result = jsonUtil.obterValorChaveJson(null, chave);

        assertNull(result);
    }

    @Test
    void obterValorChaveJson_NullKey_ShouldReturnNull() throws Exception {
        String json = "{\"key1\": \"value1\", \"key2\": \"value2\"}";

        String result = jsonUtil.obterValorChaveJson(json, null);

        assertNull(result);
    }

    @Test
    void obterValorChaveJson_NullJsonAndNullKey_ShouldReturnNull() throws Exception {
        String result = jsonUtil.obterValorChaveJson(null, null);

        assertNull(result);
    }

    @Test
    void obterValorChaveJson_ValidJsonArrayAndKeyExists_ShouldReturnExpectedValue() throws Exception {
        String json = "[{\"key1\": \"value1\"}, {\"key2\": \"value2\"}]";
        String chave = "key1";
        ArrayNode rootNode = new ObjectMapper().createArrayNode();
        ObjectNode childNode = new ObjectMapper().createObjectNode();
        childNode.put("key1", "value1");
        rootNode.add(childNode);
        when(objectMapper.readTree(anyString())).thenReturn(rootNode);

        String result = jsonUtil.obterValorChaveJson(json, chave);

        assertEquals("\"value1\"", result);
    }

    @Test
    void obterValorChaveJson_ChildKeyExists_ShouldReturnExpectedValue() throws Exception {
        String json = "{\"parent\": {\"child\": \"value\"}}";
        String chave = "parent.child";
        ObjectNode rootNode = new ObjectMapper().createObjectNode();
        ObjectNode childNode = new ObjectMapper().createObjectNode();
        childNode.put("child", "value");
        rootNode.set("parent", childNode);
        when(objectMapper.readTree(anyString())).thenReturn(rootNode);

        String result = jsonUtil.obterValorChaveJson(json, chave);

        assertEquals(null, result);
    }

    @Test
    void obterValorChaveJson_ValidJsonAndKeyNotExists_ShouldReturnNull() throws Exception {
        String json = "{\"key1\": \"value1\", \"key2\": \"value2\"}";
        String chave = "key3";
        ObjectNode rootNode = new ObjectMapper().createObjectNode();
        rootNode.put("key1", "value1");
        when(objectMapper.readTree(anyString())).thenReturn(rootNode);

        String result = jsonUtil.obterValorChaveJson(json, chave);

        assertNull(result);
    }


}
