package com.micropos.posdelivery;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PosDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosDeliveryApplication.class, args);
	}

	@Bean
	public Consumer<String> deliverCart(){
		return new CartDelivery();
	}

}
