package com.techchallenge.soat3mspagamentos.adapter.pagamento;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.usecase.PagamentoUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PagamentoControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PagamentoUseCase pagamentoUseCase;

    @Test
    void deveriaCriarPagamentoQuandoSolicitado() throws Exception {
        PagamentoModel request = new PagamentoModel();
        PagamentoModel response = new PagamentoModel();
        when(pagamentoUseCase.criarPagamento(any(PagamentoModel.class))).thenReturn(response);

        mockMvc.perform(post("/v1/pagamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(response.getId()));
    }

    @Test
    void deveriaConfirmarPagamentoQuandoSolicitado() throws Exception {
        Long idPagamentoMP = 1L;
        PagamentoModel response = new PagamentoModel();
        when(pagamentoUseCase.confirmarPagamento(idPagamentoMP)).thenReturn(response);

        mockMvc.perform(put("/v1/pagamentos/{idPagamentoMP}", idPagamentoMP))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(response.getId()));
    }
}
