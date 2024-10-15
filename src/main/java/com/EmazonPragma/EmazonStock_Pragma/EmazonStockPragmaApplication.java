package com.EmazonPragma.EmazonStock_Pragma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmazonStockPragmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmazonStockPragmaApplication.class, args);
	}

}
