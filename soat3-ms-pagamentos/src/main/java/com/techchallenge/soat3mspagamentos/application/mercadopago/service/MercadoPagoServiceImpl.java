package com.techchallenge.soat3mspagamentos.application.mercadopago.service;

import com.techchallenge.soat3mspagamentos.adapter.mercadopago.MercadoPagoClient;
import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.PagadorMP;
import com.techchallenge.soat3mspagamentos.adapter.mercadopago.model.PagamentoMPRequest;
import com.techchallenge.soat3mspagamentos.adapter.pagamento.model.PagamentoModel;
import com.techchallenge.soat3mspagamentos.commons.utils.JsonUtil;
import com.techchallenge.soat3mspagamentos.domain.model.enumerate.StatusPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MercadoPagoServiceImpl implements MercadoPagoService {

    @Value("${mp.token}")
    private String authorization;

    private static final String PIX = "pix";
    private static final String QR_CODE = "qr_code";
    private static final String QR_CODE_BASE_64 = "qr_code_base64";
    private static final String ID = "id";
    private static final String DESCRIPTION = "description";

    private final MercadoPagoClient mercadoPagoClient;

    private final JsonUtil jsonUtil;
    @Override
    public PagamentoModel criarPagamento(PagamentoModel pagamento) {

        UUID idPagamento = UUID.randomUUID();

        String response = mercadoPagoClient.criarPagamento(authorization, PagamentoMPRequest.builder()
                .valor(pagamento.getPreco())
                .payer(PagadorMP.builder().email(pagamento.getCliente().getEmail()).build())
                .metodoDePagamento(PIX)
                .descricao(String.valueOf(idPagamento))
                .build());

        String qrCopiaCola = jsonUtil.obterValorChaveJson(response, QR_CODE);

        String qrImage = jsonUtil.obterValorChaveJson(response, QR_CODE_BASE_64);

        String idPagamentoMP = jsonUtil.obterValorChaveJson(response, ID);

        pagamento.setId(idPagamento);

        pagamento.setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);

        pagamento.setCodigoPix(qrCopiaCola);

        pagamento.setQrCode(qrImage.getBytes());

        pagamento.setIdPagamentoMP(idPagamentoMP);

        return pagamento;
    }

    @Override
    public PagamentoModel confirmarPagamento(Long idPagamento) {

        String pagamentoMP =  mercadoPagoClient.confirmarPagamento(authorization, idPagamento);


        String uuidPedido = jsonUtil.obterValorChaveJson(pagamentoMP, DESCRIPTION);

        String uuid = removeAspas(uuidPedido);

        return PagamentoModel.builder()
                .id(UUID.fromString(uuid))
                .idPagamentoMP(String.valueOf(idPagamento))
                .statusPagamento(StatusPagamento.PAGO)
                .build();
    }


    private String removeAspas(String palavra) {
        return palavra.replace("\"", "");
    }
}
