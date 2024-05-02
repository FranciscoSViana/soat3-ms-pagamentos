package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.NegocioException;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.PagamentoNaoLocalizadoException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.techchallenge.soat3mspagamentos.domain.constant.I18n.ERRO_PAGAMENTO_MP;
import static java.lang.String.format;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CriarPagamentoUseCaseImpl implements  CriarPagamentoUseCase {

    private final MercadoPagoService mercadoPagoService;

    @Override
    public PagamentoModel criarPagamento(PagamentoModel request) {
        try{
            return mercadoPagoService.criarPagamento(request);
        }catch(Exception e){
            throw new NegocioException(format(ERRO_PAGAMENTO_MP,request.getId()));
        }

    }
}
