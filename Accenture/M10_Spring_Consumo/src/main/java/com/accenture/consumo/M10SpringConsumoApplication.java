package com.accenture.consumo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients; // 1. IMPORTANTE: Adicione este import

@SpringBootApplication
@EnableFeignClients // 2. IMPORTANTE: Adicione esta anotação aqui!
public class M10SpringConsumoApplication {

	public static void main(String[] args) {
		SpringApplication.run(M10SpringConsumoApplication.class, args);
	}

}