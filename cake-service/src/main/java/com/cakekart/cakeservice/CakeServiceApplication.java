package com.cakekart.cakeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.cakekart.cakeservice.repository")
public class CakeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeServiceApplication.class, args);
	}

}
