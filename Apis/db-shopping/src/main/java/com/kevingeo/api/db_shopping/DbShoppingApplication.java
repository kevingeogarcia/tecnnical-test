package com.kevingeo.api.db_shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DbShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbShoppingApplication.class, args);
	}

}
