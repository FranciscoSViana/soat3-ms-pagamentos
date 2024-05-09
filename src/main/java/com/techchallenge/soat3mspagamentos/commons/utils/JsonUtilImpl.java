package com.techchallenge.soat3mspagamentos.commons.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class JsonUtilImpl implements JsonUtil {

    private final ObjectMapper objectMapper;

    @Override
    public String obterValorChaveJson(String json, String chave) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            Optional<JsonNode> value = findNode(rootNode, chave);
            return value.map(JsonNode::toString).orElse(null);
        } catch (Exception e) {
            handleException(e);
            return null;
        }
    }

    private Optional<JsonNode> findNode(JsonNode node, String key) {
        if (node.isObject()) {
            return findObjectNode(node, key);
        } else if (node.isArray()) {
            return findArrayNode(node, key);
        }
        return Optional.empty();
    }

    private Optional<JsonNode> findObjectNode(JsonNode node, String key) {
        if (node.has(key)) {
            return Optional.of(node.get(key));
        } else {
            for (JsonNode childNode : node) {
                Optional<JsonNode> found = findNode(childNode, key);
                if (found.isPresent()) {
                    return found;
                }
            }
        }
        return Optional.empty();
    }

    private Optional<JsonNode> findArrayNode(JsonNode node, String key) {
        for (JsonNode childNode : node) {
            Optional<JsonNode> found = findNode(childNode, key);
            if (found.isPresent()) {
                return found;
            }
        }
        return Optional.empty();
    }

    private void handleException(Exception e) {
        log.info(String.valueOf(e));
    }
}