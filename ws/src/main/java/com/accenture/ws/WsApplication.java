package com.accenture.ws;

import com.accenture.ws.impl.CafeClerk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	@Bean
	public CafeClerk cafeClerk() {
		return new CafeClerk(1L, "Jane Doe");
	}
}