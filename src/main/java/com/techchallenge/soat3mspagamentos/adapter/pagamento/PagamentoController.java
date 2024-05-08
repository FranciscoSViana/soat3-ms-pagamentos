package com.techchallenge.soat3mspagamentos.adapter.pagamento;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.pagamento.usecase.PagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/pagamentos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PagamentoController {

    private final PagamentoUseCase pagamentoUseCase;
    @PostMapping
    public ResponseEntity<PagamentoModel> criarPagamento(@RequestBody PagamentoModel request) {

        PagamentoModel pagamento = pagamentoUseCase.criarPagamento(request);

        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{idPagamentoMP}")
    public ResponseEntity<PagamentoModel> confirmarPagamento(@PathVariable Long idPagamentoMP) {

        PagamentoModel pagamento = pagamentoUseCase.confirmarPagamento(idPagamentoMP);

        return ResponseEntity.ok(pagamento);
    }


}
