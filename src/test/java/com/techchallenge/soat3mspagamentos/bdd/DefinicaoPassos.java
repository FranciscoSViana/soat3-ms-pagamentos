package com.techchallenge.soat3mspagamentos.bdd;
import com.techchallenge.soat3mspagamentos.adapter.pagamento.PagamentoController;
import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.usecase.PagamentoUseCase;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefinicaoPassos {

    @InjectMocks
    private PagamentoController pagamentoController;

    @Mock
    private PagamentoUseCase pagamentoUseCase;

    private PagamentoModel pagamentoRequest;
    private PagamentoModel pagamentoResponse;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Dado("um pagamento é solicitado")
    public void umPagamentoESolicitado() {
        pagamentoRequest = new PagamentoModel();
    }

    @Quando("o endpoint de criação de pagamento é chamado")
    public void oEndpointDeCriacaoDePagamentoEChamado() {
        pagamentoResponse = new PagamentoModel(); // Simulação de resposta do caso de uso
        when(pagamentoUseCase.criarPagamento(any(PagamentoModel.class))).thenReturn(pagamentoResponse);
    }

    @Então("o pagamento é criado com sucesso")
    public void oPagamentoECriadoComSucesso() {
        ResponseEntity<PagamentoModel> responseEntity = pagamentoController.criarPagamento(pagamentoRequest);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pagamentoResponse, responseEntity.getBody());
    }

}
