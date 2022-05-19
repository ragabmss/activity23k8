package com.microservices.fasttrack.CurrencyConverted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConvertedApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertedApplication.class, args);
	}

}
