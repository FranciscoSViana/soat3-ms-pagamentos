package com.techchallenge.soat3mspagamentos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techchallenge.soat3mspagamentos.application.pagamento.model.PagamentoModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Soat3MsPagamentosApplication {

	public static final String PACKAGE = "com.techchallenge.soat3mspagamentos";
	public static void main(String[] args) {
		SpringApplication.run(Soat3MsPagamentosApplication.class, args);
	}



}
