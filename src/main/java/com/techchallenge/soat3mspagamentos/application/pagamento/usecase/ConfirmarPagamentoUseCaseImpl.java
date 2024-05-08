package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import com.techchallenge.soat3mspagamentos.application.pagamento.exception.PagamentoNaoLocalizadoException;
import static com.techchallenge.soat3mspagamentos.domain.constant.I18n.PAGAMENTO_NAO_LOCALIZADO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConfirmarPagamentoUseCaseImpl implements ConfirmarPagamentoUseCase {

    private final MercadoPagoService mercadoPagoService;
    @Override
    public PagamentoModel confirmarPagamento(Long idPagamentoMP) {

        try{
            return mercadoPagoService.confirmarPagamento(idPagamentoMP);
        }catch(Exception e){
            throw new PagamentoNaoLocalizadoException(format(PAGAMENTO_NAO_LOCALIZADO,idPagamentoMP));
        }
    }

}
