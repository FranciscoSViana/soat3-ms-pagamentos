package com.techchallenge.soat3mspagamentos.infrastruture.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import static com.techchallenge.soat3mspagamentos.Soat3MsPagamentosApplication.PACKAGE;


@Configuration
@EnableFeignClients(PACKAGE)
public class FeignClientConfig {
}
