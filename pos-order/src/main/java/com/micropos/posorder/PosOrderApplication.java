package com.micropos.posorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.micropos.order.*"})
@EnableDiscoveryClient
public class PosOrderApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name","order");
		SpringApplication.run(PosOrderApplication.class, args);
	}

}
