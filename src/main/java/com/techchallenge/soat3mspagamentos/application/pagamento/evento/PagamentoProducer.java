package com.techchallenge.soat3mspagamentos.application.pagamento.evento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.NegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.techchallenge.soat3mspagamentos.domain.constant.I18n.TOPICO_CONFIRMACAO_PAGAMENTO;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PagamentoProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void enviarPagamento(PagamentoModel pagamentoModel) {
        try {
            String pagamentoJson = objectMapper.writeValueAsString(pagamentoModel);
            kafkaTemplate.send(TOPICO_CONFIRMACAO_PAGAMENTO, pagamentoJson);
        } catch (Exception e) {
            throw new NegocioException(format("Erro ao produzir pagamento: %s", e.getMessage()));
        }
    }
}