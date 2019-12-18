package com.usbtc.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class KioskApplication {

	public static void main(String[] args) {
		SpringApplication.run(KioskApplication.class, args);
	}

}
