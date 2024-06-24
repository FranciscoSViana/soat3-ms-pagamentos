package com.techchallenge.soat3mspagamentos.application.pagamento.evento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.NegocioException;
import com.techchallenge.soat3mspagamentos.application.pagamento.usecase.PagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.techchallenge.soat3mspagamentos.domain.constant.I18n.GRUPO_ID;
import static com.techchallenge.soat3mspagamentos.domain.constant.I18n.TOPICO_SOLICITACAO_PAGAMENTO;
import static java.lang.String.format;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PagamentoConsumer {

    private final PagamentoUseCase pagamentoUseCase;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = TOPICO_SOLICITACAO_PAGAMENTO, groupId = GRUPO_ID)
    public void consume(@Payload String pagamentoJson) {
        try {
            PagamentoModel pagamento = objectMapper.readValue(pagamentoJson, PagamentoModel.class);
            pagamentoUseCase.criarPagamento(pagamento);
        } catch (Exception e) {
            throw new NegocioException(format("Erro ao consumir pagamento: %s", e.getMessage()));
        }
    }
}
