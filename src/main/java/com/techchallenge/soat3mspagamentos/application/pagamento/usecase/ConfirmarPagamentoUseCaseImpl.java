package com.techchallenge.soat3mspagamentos.application.pagamento.usecase;

import com.techchallenge.soat3mspagamentos.application.mercadopago.service.MercadoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ConfirmarPagamentoUseCaseImpl implements ConfirmarPagamentoUseCase {

    private final MercadoPagoService mercadoPagoService;
    @Override
    public void confirmarPagamento(Long idPagamentoMP) {

//        try{
//             mercadoPagoService.confirmarPagamento(idPagamentoMP);
//        }catch(Exception e){
//            throw new PagamentoNaoLocalizadoException(format(PAGAMENTO_NAO_LOCALIZADO,idPagamentoMP));
//        }
    }

}
